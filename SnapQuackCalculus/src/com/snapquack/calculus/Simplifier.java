package com.snapquack.calculus;

public class Simplifier {
    /*
     * purpose: to simplfiy an expression and make it more readable, this class
     * only determines the type of Expression and then calls the appropriate
     * method to do the work i.e. add, multiply, factor, divide etc.
     */
    public static Expression simplify(Expression original) {
        Expression result = original;
        if (original.op1 == null && original.fcn_name.equals(""))
            result = original;
        if (original.operator == '^') {
            if ((int) original.op2.coe == original.op2.coe && original.op2.fcn_name == ""
                    && original.op2.op1 == null && original.op2.exp == 0)
                result = expand(simplify(original.op1), (int) original.op2.coe);
            else{
                result = new Expression(simplify(original.op1), '^', simplify(original.op2));
                result.open_bracket=result.cls_bracket=true;
            }
        }
        if (original.operator == '*') {
            if (original.op1.operator == '+' && original.op2.operator != '-'
                    && original.op2.operator != '+' && !original.op1.open_bracket)
                result = add(original.op1.op1, multiply(original.op1.op2, original.op2));
            else if (original.op1.operator == '-' && original.op2.operator != '-'
                    && original.op2.operator != '+' && !original.op1.open_bracket)
                result = subtract(original.op1.op1, multiply(original.op1.op2, original.op2));
            else if (original.op2.operator == '+' && original.op1.operator != '-'
                    && original.op1.operator != '+' && !original.op2.open_bracket)
                result = add(original.op2.op1, multiply(original.op2.op2, original.op1));
            else if (original.op2.operator == '-' && original.op1.operator != '-'
                    && original.op1.operator != '+' && !original.op2.open_bracket)
                result = subtract(original.op2.op1, multiply(original.op2.op2, original.op1));
            else if (original.op2.operator != '+' && original.op2.operator != '-'
                    && original.op1.operator != '-' && original.op1.operator != '+')
                result = multiply(simplify(original.op1), simplify(original.op2));
            else
                result = multiply(original.op1, original.op2);
        }
        if (original.operator == '/') {
            if (original.op1.operator == '+' && original.op2.operator != '-'
                    && original.op2.operator != '+' && !original.op1.open_bracket)
                result = add(original.op1.op1, divide(original.op1.op2, original.op2));
            else if (original.op1.operator == '-' && original.op2.operator != '-'
                    && original.op2.operator != '+' && !original.op1.open_bracket)
                result = subtract(original.op1.op1, divide(original.op1.op2, original.op2));
            else if (original.op2.operator == '+' && original.op1.operator != '-'
                    && original.op1.operator != '+' && !original.op2.open_bracket)
                result = add(original.op2.op1, divide(original.op2.op2, original.op1));
            else if (original.op2.operator == '-' && original.op1.operator != '-'
                    && original.op1.operator != '+' && !original.op2.open_bracket)
                result = subtract(original.op2.op1, divide(original.op2.op2, original.op1));
            else
                result = divide(simplify(original.op1), simplify(original.op2));
        }
        if (original.operator == '+')
            result = add(simplify(original.op1), simplify(original.op2));
        if (original.operator == '-')
            result = subtract(simplify(original.op1), simplify(original.op2));
        if (original.fcn_name != "") {
            result = new Expression(original.fcn_name, simplify(original.fcn_input));
            result.coe = original.coe;
            result.exp = original.exp;
        }
        return result;

    }

    /*
     * Purpose: To simplify an expression into common terms.
     */
    public static Expression add(Expression first_operand, Expression second_operand) {
        Expression result = new Expression();
        if (first_operand.toString().equals("0"))
            return new Expression(second_operand);
        if (second_operand.toString().equals("0"))
            return new Expression(first_operand);
        if (first_operand.operator == '*' || first_operand.operator == '/'
                || second_operand.operator == '*' || second_operand.operator == '/')
            return new Expression(first_operand, '+', second_operand);
        if (first_operand.operator == '/' || second_operand.operator == '/')
            return new Expression(first_operand, '+', second_operand);
        if (first_operand.op1 == null && second_operand.op1 == null) {
            if (first_operand.coe == 0)
                return second_operand;
            if (second_operand.coe == 0)
                return first_operand;
            if (first_operand.exp == second_operand.exp
                    && first_operand.fcn_name.equals(second_operand.fcn_name)) {
                if (!(first_operand.fcn_input != null && second_operand.fcn_input != null)
                        || first_operand.fcn_input.equals(second_operand.fcn_input)) {
                    result.coe = first_operand.coe + second_operand.coe;
                    result.exp = first_operand.exp;
                    result.fcn_name = first_operand.fcn_name;
                    result.fcn_input = first_operand.fcn_input;
                }
                else
                    result = new Expression(first_operand, '+', second_operand);
            }
            else
                result = new Expression(first_operand, '+', second_operand);
        }
        else if (first_operand.op1 != null && second_operand.op1 == null) {
            if (first_operand.operator == '-') {
                first_operand.op2 = negate(first_operand.op2);
                first_operand.operator = '+';
            }
            Expression sum1 = add(first_operand.op1, second_operand);
            if (sum1.equals(new Expression(first_operand.op1, '+', second_operand)))
                sum1 = first_operand.op1;
            Expression sum2 = add(first_operand.op2, second_operand);
            if (sum2.equals(new Expression(first_operand.op2, '+', second_operand)))
                sum2 = first_operand.op2;
            Expression totalSum = new Expression(sum1, first_operand.operator, sum2);
            totalSum.open_bracket = totalSum.cls_bracket = first_operand.cls_bracket;
            if (totalSum.equals(first_operand))
                result = new Expression(first_operand, '+', second_operand);
            else
                result = totalSum;
        }
        else if (first_operand.op1 == null && second_operand.op1 != null) {
            if (second_operand.operator == '-') {
                second_operand.op2 = negate(second_operand.op2);
                second_operand.operator = '+';
            }
            Expression sum1 = add(first_operand, second_operand.op1);
            if (sum1.equals(new Expression(first_operand, '+', second_operand.op1)))
                sum1 = second_operand.op1;
            Expression sum2 = add(first_operand, second_operand.op2);
            if (sum2.equals(new Expression(first_operand, '+', second_operand.op2)))
                sum2 = second_operand.op2;
            Expression totalSum = new Expression(sum1, second_operand.operator, sum2);
            totalSum.open_bracket = totalSum.cls_bracket = second_operand.cls_bracket;
            if (totalSum.equals(second_operand))
                result = new Expression(first_operand, '+', second_operand);
            else
                result = totalSum;
        } else {
            Expression temp = add(first_operand, second_operand.op1);
            if (second_operand.operator == '+')
                result = add(temp, second_operand.op2);
            else {
                second_operand.op2 = negate(second_operand.op2);
                second_operand.operator = '+';
                result = add(temp, second_operand.op2);
            }
        }
        return result;
    }

    public static Expression subtract(Expression first_operand, Expression second_operand) {
        Expression result = new Expression();
        if (first_operand.toString().equals("0"))
            return negate(second_operand);
        if (second_operand.toString().equals("0"))
            return new Expression(first_operand);
        if (first_operand.op1 == null && second_operand.op1 == null) {
            if (first_operand.exp == second_operand.exp
                    && first_operand.fcn_name.equals(second_operand.fcn_name)) {
                if (!(first_operand.fcn_input != null && second_operand.fcn_input != null)
                        || first_operand.fcn_input.equals(second_operand.fcn_input)) {
                    result.coe = first_operand.coe - second_operand.coe;
                    result.exp = first_operand.exp;
                    result.fcn_name = first_operand.fcn_name;
                    result.fcn_input = first_operand.fcn_input;
                }
                else
                    result = new Expression(first_operand, '-', second_operand);
            }
            else
                result = new Expression(first_operand, '-', second_operand);
        }
        else if (first_operand.op1 != null && second_operand.op1 == null) {
            if (first_operand.operator == '-') {
                first_operand.op2 = negate(first_operand.op2);
                first_operand.operator = '+';
            }
            Expression diff1 = subtract(first_operand.op1, second_operand);
            if (diff1.equals(new Expression(first_operand.op1, '-', second_operand)))
                diff1 = first_operand.op1;
            Expression diff2 = subtract(first_operand.op2, second_operand);
            if (diff2.equals(new Expression(first_operand.op2, '-', second_operand)))
                diff2 = first_operand.op2;
            Expression totalDiff = new Expression(diff1, first_operand.operator, diff2);
            totalDiff.open_bracket = totalDiff.cls_bracket = first_operand.cls_bracket;
            if (totalDiff.equals(first_operand))
                result = new Expression(first_operand, '-', second_operand);
            else
                result = totalDiff;
        }
        else if (first_operand.op1 == null && second_operand.op1 != null) {
            if (second_operand.operator == '-') {
                second_operand.op2 = negate(second_operand.op2);
                second_operand.operator = '+';
            }
            Expression diff1 = subtract(first_operand, second_operand.op1);
            if (diff1.equals(new Expression(first_operand, '-', second_operand.op1)))
                diff1 = second_operand.op1;
            Expression diff2 = subtract(first_operand, second_operand.op2);
            if (diff2.equals(new Expression(first_operand, '-', second_operand.op2)))
                diff2 = second_operand.op2;
            Expression totalDiff = new Expression(diff1, second_operand.operator, diff2);
            totalDiff.open_bracket = totalDiff.cls_bracket = second_operand.cls_bracket;
            if (totalDiff.equals(second_operand))
                result = new Expression(first_operand, '-', second_operand);
            else
                result = totalDiff;
        } else {
            Expression temp = subtract(first_operand, second_operand.op1);
            result = subtract(temp, second_operand.op2);
        }
        return result;
    }

    public static Expression multiply(Expression first_operand, Expression second_operand) {
        Expression result = new Expression();
        if (first_operand.toString().equals("0"))
            return new Expression(0, 0);
        if (second_operand.toString().equals("0"))
            return new Expression(0, 0);
        if (first_operand.toString().equals("1"))
            return new Expression(second_operand);
        if (second_operand.toString().equals("1"))
            return new Expression(first_operand);
        if (first_operand.op1 == null && second_operand.op1 == null) {
            if (first_operand.exp == 0) {
                result = new Expression(second_operand);
                result.coe *= first_operand.coe;
                return result;
            }
            if (second_operand.exp == 0) {
                result = new Expression(first_operand);
                result.coe *= second_operand.coe;
                return result;
            }
            if (first_operand.coe == 0 || second_operand.coe == 0)
                return new Expression(0, 0);
            else if (first_operand.fcn_name.equals(second_operand.fcn_name)) {
                if (!(first_operand.fcn_input != null && second_operand.fcn_input != null)
                        || first_operand.fcn_input.equals(second_operand.fcn_input)) {
                    result.coe = first_operand.coe * second_operand.coe;
                    result.exp = first_operand.exp + second_operand.exp;
                    result.fcn_name = first_operand.fcn_name;
                    result.fcn_input = first_operand.fcn_input;
                } else
                    result = new Expression(first_operand, '*', second_operand);
            } else
                result = new Expression(first_operand, '*', second_operand);
        } else if (first_operand.op1 != null && second_operand.op1 == null) {
            if (first_operand.operator == '/') {
                Expression temp1 = multiply(first_operand.op1, second_operand);
                temp1.cls_bracket = temp1.open_bracket = true;
                result = new Expression(temp1, '/', first_operand.op2);
            }
            else if (first_operand.operator == '^') {
                if (first_operand.op1.equals(second_operand)) {
                    first_operand.op2 = simplify(add(first_operand.op2, new Expression(
                            second_operand.exp, 0)));
                    result = new Expression(first_operand.op1, '^', first_operand.op2);
                }
                else
                    result = new Expression(first_operand, '*', second_operand);
            }
            else if (first_operand.operator == '*')
                result = new Expression(first_operand, '*', second_operand);
            else {
                Expression temp1 = multiply(first_operand.op1, second_operand);
                temp1.cls_bracket = temp1.open_bracket = first_operand.op1.cls_bracket;
                Expression temp2 = multiply(first_operand.op2, second_operand);
                temp2.cls_bracket = temp2.open_bracket = first_operand.op2.cls_bracket;
                result = new Expression(temp1, first_operand.operator, temp2);
            }
        }
        else if (first_operand.op1 == null && second_operand.op1 != null) {
            if (second_operand.operator == '/') {
                Expression temp1 = multiply(second_operand.op1, first_operand);
                temp1.cls_bracket = temp1.open_bracket = true;
                result = new Expression(temp1, '/', second_operand.op2);
            }
            else if (second_operand.operator == '^')
                if (second_operand.op1.equals(first_operand)) {
                    second_operand.op2 = simplify(add(second_operand.op2, new Expression(
                            first_operand.exp, 0)));
                    result = new Expression(second_operand.op1, '^', second_operand.op2);
                }
                else
                    result = new Expression(first_operand, '*', second_operand);
            else if (second_operand.operator == '*')
                result = new Expression(first_operand, '*', second_operand);
            else {
                Expression temp1 = multiply(first_operand, second_operand.op1);
                temp1.cls_bracket = temp1.open_bracket = second_operand.op1.cls_bracket;
                Expression temp2 = multiply(first_operand, second_operand.op2);
                temp2.cls_bracket = temp2.open_bracket = second_operand.op2.cls_bracket;
                result = new Expression(temp1, second_operand.operator, temp2);
            }
        }
        else if (first_operand.op1 != null && second_operand.op1 != null) {
            result = foil(first_operand, second_operand);
        }
        else {
            result = new Expression(first_operand, '*', second_operand);
        }
        return result;
    }

    /*
     * Assuming that the previous operator was a '-', negates the appropriate
     * terms according to the bracketing used.
     */
    public static Expression negate(Expression original) {
        Expression current = original;
        Expression previous = null;
        char operator = 'a';
        while (current.op1 != null && !current.open_bracket) {
            operator = current.operator;
            previous = current.op2;
            current = current.op1;
        }
        current = multiply(new Expression(-1, 0), current);
        if (previous != null)
            return new Expression(current, operator, previous);
        return current;
    }

    public static Expression foil(Expression first_operand, Expression second_operand) {
        Expression result = null;
        if (first_operand.operator == '/') {
            Expression numerator = multiply(first_operand.op1, second_operand);
            result = new Expression(numerator, '/', first_operand.op2);
        } else if (second_operand.operator == '/') {
            Expression numerator = multiply(second_operand.op1, first_operand);
            result = new Expression(numerator, '/', second_operand.op2);
        } else {
            if (first_operand.operator == '-')
                first_operand.op2 = multiply(new Expression(-1, 0), first_operand.op2);
            if (second_operand.operator == '-')
                second_operand.op2 = multiply(new Expression(-1, 0), second_operand.op2);
            Expression first = multiply(first_operand.op1, second_operand.op1);
            Expression outer = multiply(first_operand.op1, second_operand.op2);
            Expression inner = multiply(first_operand.op2, second_operand.op1);
            Expression last = multiply(first_operand.op2, second_operand.op2);

            Expression temp1 = new Expression(first, '+', last);
            Expression temp2 = new Expression(inner, '+', outer);

            result = new Expression(temp1, '+', temp2);
            result = simplify(result);
        }
        return result;
    }

    public static Expression divide(Expression first_operand, Expression second_operand) {
        Expression result = new Expression();
        if (first_operand.op1 == null && second_operand.op1 == null) {
            if (first_operand.fcn_name.equals(second_operand.fcn_name)) {
                if (!(first_operand.fcn_input != null && second_operand.fcn_input != null)
                        || first_operand.fcn_input.equals(second_operand.fcn_input)) {
                    result.coe = first_operand.coe / second_operand.coe;
                    result.exp = first_operand.exp - second_operand.exp;
                    result.fcn_name = first_operand.fcn_name;
                    result.fcn_input = first_operand.fcn_input;
                } else
                    result = new Expression(first_operand, '/', second_operand);
            } else
                result = new Expression(first_operand, '/', second_operand);
        } else if (first_operand.op1 != null && second_operand.op1 == null) {
            if (first_operand.operator == '+' || first_operand.operator == '-') {
                Expression temp1 = divide(first_operand.op1, second_operand);
                Expression temp2 = divide(first_operand.op2, second_operand);
                result = new Expression(temp1, first_operand.operator, temp2);
            }
            else {
                result = new Expression(first_operand, '/', second_operand);
            }
        }
        else if (first_operand.op1 == null && second_operand.op1 != null) {
            result = new Expression(first_operand, '/', second_operand);
        }
        else {
            if (contains_fcn(first_operand) || contains_fcn(second_operand))
                result = new Expression(first_operand, '/', second_operand);
            else {
                Expression factorednumerator = factor(first_operand);
                Expression factoreddenominator = factor(second_operand);
                result = cancelTerms(factorednumerator, factoreddenominator);
                if (result.equals(new Expression(factorednumerator, '/', factoreddenominator)))
                    result = new Expression(first_operand, '/', second_operand);
            }
        }
        return result;
    }

    // Reads through the array of roots for each term and if they have roots in
    // common removes them.
    public static Expression cancelTerms(Expression numerator, Expression denominator) {
        Expression result;
        if (numerator.roots == null || denominator.roots == null)
            result = new Expression(numerator, '/', denominator);
        else {
            for (int i = 0; i < numerator.roots.length; i++)
                for (int j = 0; j < denominator.roots.length; j++) {
                    if (numerator.roots[i] == denominator.roots[j]) {
                        numerator.roots[i] = denominator.roots[j] = 0;
                    }
                }
            result = new Expression(new Expression(numerator.roots), '/', new Expression(
                    denominator.roots));
        }
        return result;
    }

    // Reads through an expression and determines if it contains a function or
    // if it is a polynomial.
    public static boolean contains_fcn(Expression original) {
        boolean result = false;
        if (original.op1.op1 == null) {
            if (original.op1.fcn_name == "") {
                result |= false;
            }
            else
                result |= true;
        }
        else {
            result |= contains_fcn(original.op1);
        }
        if (original.op2.op1 == null) {
            if (original.op2.fcn_name == "") {
                result |= false;
            }
            else
                result |= true;
        }
        else {
            result |= contains_fcn(original.op2);
        }
        return result;
    }

    public static Expression factor(Expression original) {
        int highest = highest_power(original);
        int lowest = lowest_power(original);
        if (lowest < 0)
            return original;
        double coefficient = Math.abs(constant_finder(original));
        Expression x = new Expression(1, 1);
        if (coefficient == 0) {
            Expression result;
            result = removePower(original);
            result = factor(result);
            result = new Expression(result, '*', x);
            return result;
        }
        int[] roots = new int[highest];
        for (int index = 0; index < roots.length; index++)
            roots[index] = Integer.MAX_VALUE;
        int position = 0;
        for (int i = 0; i <= coefficient; i++) {
            if (coefficient % i == 0) {
                if (substitute(original, i) == 0) {
                    roots[position++] = i;
                    if (position == roots.length)
                        break;
                    Expression derivative = new Expression(original);
                    while (substitute(Deriver.derive(derivative), i) == 0) {
                        roots[position] = i;
                        if (position == roots.length)
                            break;
                        derivative = Deriver.derive(derivative);
                    }
                }
                if (substitute(original, -i) == 0) {
                    roots[position++] = -i;
                    if (position == roots.length)
                        break;
                    Expression derivative = new Expression(original);
                    while (substitute(Deriver.derive(derivative), -i) == 0) {
                        roots[position] = -i;
                        if (position == roots.length)
                            break;
                        derivative = Deriver.derive(derivative);
                    }
                }
            }
        }
        boolean full = true;
        for (int index = 0; index < roots.length; index++)
            if (roots[index] == Integer.MAX_VALUE)
                full = false;
        if (full == true)
            return new Expression(roots);
        return original;

    }

    public static int lowest_power(Expression original) {
        if (original.op1 == null) {
            if (original.exp == (int) original.exp)
                return (int) original.exp;
            return 0;
        }
        else
            return Math.min(lowest_power(original.op1), lowest_power(original.op2));
    }

    public static Expression removePower(Expression original) {
        if (original.op1 == null)
            return new Expression(original.coe, original.exp - 1);
        return new Expression(removePower(original.op1), original.operator,
                removePower(original.op2));
    }

    public static int highest_power(Expression original) {
        if (original.op1 == null) {
            if (original.exp == (int) original.exp)
                return (int) original.exp;
            return 0;
        }
        else
            return Math.max(highest_power(original.op1), highest_power(original.op2));
    }

    public static double constant_finder(Expression original) {
        if (original.op1 == null)
            if (original.exp == 0 && original.coe == (int) original.coe)
                return original.coe;
            else
                return 0;
        else
            return constant_finder(original.op1) + constant_finder(original.op2);
    }

    public static Expression expand(Expression original, int exponent) {
        Expression result = new Expression(original);
        if (exponent < 0)
            return new Expression(original, '^', new Expression(exponent, 0f));
        while (exponent > 1) {
            result = multiply(result, original);
            exponent--;
        }
        return result;
    }

    /*
     * purpose:evaluates the expression at the given value
     */
    public static double substitute(Expression original, double value) {
        if (original.op1 == null && original.fcn_name == "")
            return original.coe * (Math.pow(value, original.exp));
        else if (original.fcn_name == "")
            switch (original.operator) {
                case ('+'):
                    return substitute(original.op1, value) + substitute(original.op2, value);
                case ('-'):
                    return substitute(original.op1, value) - substitute(original.op2, value);
                case ('*'):
                    return substitute(original.op1, value) * substitute(original.op2, value);
                case ('/'):
                    return substitute(original.op1, value) / substitute(original.op2, value);
                case ('^'):
                    return Math.pow(substitute(original.op1, value),
                            substitute(original.op2, value));
            }
        return fcn_subs(original, value);
    }

    private static double fcn_subs(Expression original, double value) {
        if (original.fcn_name.equals("sin"))
            return Math.sin(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("cos"))
            return Math.cos(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("tan"))
            return Math.tan(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("ln"))
            return Math.log(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("exp"))
            return Math.exp(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("arccos"))
            return Math.acos(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("arcsin"))
            return Math.asin(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("arctan"))
            return Math.atan(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("csc"))
            return 1 / Math.sin(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("sec"))
            return 1 / Math.cos(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("cot"))
            return 1 / Math.tan(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("arccot"))
            return (Math.PI / 2) - Math.atan(substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("arcsec"))
            return Math.acos(1 / substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("arccsc"))
            return Math.asin(1 / substitute(original.fcn_input, value));
        else if (original.fcn_name.equals("abs"))
            return Math.abs(substitute(original.fcn_input, value));
        return 0;

    }
}
