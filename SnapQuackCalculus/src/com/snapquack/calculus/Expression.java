package com.snapquack.calculus;

public class Expression {

    double coe = 1, exp = 1;
    String fcn_name = "";
    char operator = 'a';
    boolean cls_bracket = false, open_bracket = false;
    Expression op1 = null, op2 = null, fcn_input = null;
    int[] roots = null;

    /*
     * Boring ass constructor
     */
    public Expression() {
    }

    /*
     * purpose: sets instance data to the formal parameters Status: Done +
     * tested
     */
    public Expression(Expression op1, char operator, Expression op2) {
        this.op1 = op1;
        this.operator = operator;
        this.op2 = op2;
    }

    /*
     * purpose: sets instance data to formal parameters Status: Done
     */
    public Expression(String fcn_name, Expression fcn_input) {
        this.exp = 1;
        this.coe = 1;
        this.fcn_name = fcn_name;
        this.fcn_input = fcn_input;
    }

    /*
     * purpose: sets instance data to formal parameters Status: Done + tested
     */
    public Expression(double coe, double exp) {
        this.exp = exp;
        this.coe = coe;

    }

    /*
     * purpose: to parse a string into a Expression.
     */
    public Expression(String input) {
        Expression temp = parse(input);
        this.open_bracket = temp.open_bracket;
        this.cls_bracket = temp.cls_bracket;
        this.coe = temp.coe;
        this.exp = temp.exp;
        this.fcn_name = temp.fcn_name;
        this.fcn_input = temp.fcn_input;
        this.op1 = temp.op1;
        this.op2 = temp.op2;
        this.operator = temp.operator;
    }

    /*
     * Takes and expression and creates a new instance with all the same data.
     */
    public Expression(Expression temp) {
        this.open_bracket = temp.open_bracket;
        this.cls_bracket = temp.cls_bracket;
        this.coe = temp.coe;
        this.exp = temp.exp;
        this.fcn_name = temp.fcn_name;
        this.fcn_input = temp.fcn_input;
        this.op1 = temp.op1;
        this.op2 = temp.op2;
        this.operator = temp.operator;
    }

    /*
     * Takes an array of roots and creates an expression based on these roots
     */
    public Expression(int[] roots) {
        this.roots = roots;
        Expression x = new Expression(1, 1);
        for (int i = 0; i < roots.length; i++) {
            if (roots[i] == 0) {
            }
            else {
                if (this.op1 == null) {
                    this.op1 = x;
                    this.operator = '-';
                    this.op2 = new Expression(roots[i], 0);
                    this.cls_bracket = this.open_bracket = true;
                }
                else {
                    this.op1 = new Expression(this.op1, this.operator, this.op2);
                    this.cls_bracket = this.open_bracket = false;
                    this.op1.cls_bracket = this.op1.open_bracket = true;
                    this.operator = '*';
                    this.op2 = new Expression(x, '-', new Expression(roots[i], 0));
                    this.op2.cls_bracket = this.op2.open_bracket = true;
                }
            }
        }
        if (this.op1 == null)
            this.exp = 0;
    }

    /*
     * * @see ExpressionInterface#parse(java.lang.String)
     */
    
    public Expression parse(String input) {
        Expression first_term = null;
        int term_index = 1, index = 0, pcounter = 0;
        double term_exp, term_coe;
        boolean term_open = false, term_close = false;
        if (input.charAt(0) == '(') {// If the first term is a bracket, finds
                                     // the closing bracket and makes an
                                     // expression from the inside string
            pcounter++;
            term_open = term_close = true;
            while (pcounter != 0) {
                index++;
                if (input.charAt(index) == '(')
                    pcounter++;
                if (input.charAt(index) == ')')
                    pcounter--;
            }
            first_term = parse(input.substring(1, index));
            first_term.open_bracket = term_open;
            first_term.cls_bracket = term_close;
            if (index == input.length() - 1)
                return first_term;
            return new Expression(first_term, input.charAt(index + 1),
                    parse(input.substring(index + 2)));
        }
        else if (Character.isLetter(input.charAt(0)) && input.charAt(0) != 'x' && input.charAt(0) != 'π') {// If
                                                                                 // the
                                                                                 // first
                                                                                 // character
                                                                                 // is
                                                                                 // a
                                                                                 // letter
                                                                                 // that
                                                                                 // is
                                                                                 // not
                                                                                 // an
                                                                                 // x,
                                                                                 // make
                                                                                 // a
                                                                                 // new
                                                                                 // expression
                                                                                 // using
                                                                                 // the
            while (input.charAt(index) != '(')
                // function name from the string.
                index++;
            pcounter = 1;
            term_index = index + 1;
            while ((term_index < input.length() && pcounter != 0)) {
                if (input.charAt(term_index) == '(')
                    pcounter++;
                if (input.charAt(term_index) == ')')
                    pcounter--;
                term_index++;
            }
            first_term = new Expression(input.substring(0, index), parse(input.substring(index + 1,
                    term_index - 1)));
            if (term_index == input.length())
                return first_term;
            return new Expression(first_term, input.charAt(term_index),
                    parse(input.substring(term_index + 1)));
        }
        else {
            while (term_index < input.length()
                    && input.charAt(term_index) != '+'
                    && !(input.charAt(term_index) == '-' && input.charAt(term_index - 1) != '^')
                    && input.charAt(term_index) != '/'
                    && input.charAt(term_index) != '*' // This moves through the
                                                       // string looking for a
                                                       // reason to stop and go
                                                       // make a term
                    && !(input.charAt(term_index) == '^' && input.charAt(term_index - 1) != 'x')
                    && !(Character.isLetter(input.charAt(term_index)) && !(input.charAt(term_index) == 'x')&& !(input.charAt(term_index) == 'π')))
                term_index++;
            // This is for cases like 4sin(x) where we have a function and a
            // coefficient to worry about. We will handle things like sin(x)^2
            // by just raising the whole expression to the power
            // which is fine because that is how Wolfram deals with it.
            if (term_index < input.length() && Character.isLetter(input.charAt(term_index))
                    && !(input.charAt(term_index) == 'x')) {
                first_term = parse(input.substring(term_index));
                if (first_term.op1 == null)
                    first_term.coe = makeNumber(input.substring(index, term_index));
                else {
                    setFirstcoe(makeNumber(input.substring(index, term_index)), first_term.op1);
                }
                term_index += parse(input.substring(term_index)).toString().length();
            }
            else {
                if (input.charAt(0) == 'x') {
                    if (term_index == 1) {// no coefficient and no exponent so
                                          // just make x.
                        first_term = new Expression(1f, 1f);
                    }
                    else {// no coefficient but yes exponent, make x^?
                        index = 2;
                        term_exp = makeNumber(input.substring(index, term_index));
                        first_term = new Expression(1f, term_exp);
                    }
                }
                else {
                    if (input.indexOf('x') > term_index) {// This is if we have
                                                          // a constant,
                                                          // operator, constant
                                                          // i.e. 7^x
                        term_coe = makeNumber(input.substring(0, term_index));
                        first_term = new Expression(term_coe, 0);
                    } else {
                        if (input.lastIndexOf('x') == -1) {// Make a constant,
                                                           // i.e. 1, into a
                                                           // term with a 0
                                                           // exponent
                            term_coe = makeNumber(input);
                            first_term = new Expression(term_coe, 0);
                        }
                        else {
                            while (input.charAt(index) != 'x')
                                // Finds the coefficient part of the string i.e.
                                // number before the x
                                index++;
                            term_coe = makeNumber(input.substring(0, index));
                            if (term_index - index > 2)// If there is string
                                                       // left after the x, make
                                                       // it into a exponent.
                                term_exp = makeNumber(input.substring(index + 2, term_index));
                            else
                                term_exp = 1;// Otherwise set the exponent to 1
                            first_term = new Expression(term_coe, term_exp);

                        }
                        first_term.open_bracket = term_open;
                        first_term.cls_bracket = term_close;

                    }
                }
            }
        }
        if (term_index == input.length() || input.indexOf('x') == -1)
            return first_term;// If we are at the end of the input we are done.
        return new Expression(first_term, input.charAt(term_index),// Otherwise,
                                                                   // make more
                                                                   // terms in
                                                                   // the
                                                                   // expression.
                parse(input.substring(term_index + 1)));
    }

    private void setFirstcoe(double coe, Expression op) {
        Expression current = op;
        while (current.op1 != null)
            current = current.op1;
        current.coe = coe;

    }

 
    public static double makeNumber(String num_string) {
        if (num_string.indexOf("π") != -1) {
            return makeNumber(num_string.substring(0, num_string.indexOf("π"))) * Math.PI
                    * makeNumber(num_string.substring(num_string.indexOf("π") + 1));
        }         
        if (num_string.indexOf('+') != -1) {
            if(num_string.charAt(0) == '(')
                return makeNumber(num_string.substring(1, num_string.indexOf('+')))
                        + makeNumber(num_string.substring(num_string.indexOf('+') + 1, num_string.length()-1));
                return makeNumber(num_string.substring(0, num_string.indexOf('+')))
                        + makeNumber(num_string.substring(num_string.indexOf('+') + 1, num_string.length()));
        }
        if (num_string.indexOf('-',1) != -1) {
            if(num_string.charAt(0) == '(')
                return makeNumber(num_string.substring(1, num_string.indexOf('-')))
                        - makeNumber(num_string.substring(num_string.indexOf('-') + 1, num_string.length()-1));
                return makeNumber(num_string.substring(0, num_string.indexOf('-')))
                        - makeNumber(num_string.substring(num_string.indexOf('-') + 1, num_string.length()));
        }
        if (num_string.indexOf('*') != -1) {
            if(num_string.charAt(0) == '(')
            return makeNumber(num_string.substring(1, num_string.indexOf('*')))
                    * makeNumber(num_string.substring(num_string.indexOf('*') + 1, num_string.length()-1));
            return makeNumber(num_string.substring(0, num_string.indexOf('*')))
                    * makeNumber(num_string.substring(num_string.indexOf('*') + 1, num_string.length()));
        }
        if (num_string.equals(""))
            return 1;
        if (num_string.charAt(0) == '-')
            return -makeNumber(num_string.substring(1));
        int division = num_string.indexOf("/"); // Checks if the string
                                                // represents a division of
                                                // integers or doubles
        if (division != -1) { // If there is a division sign then start this
                              // sequence of calls, otherwise move on
            if (num_string.indexOf("/", division + 1) != -1) { // Checks if
                                                               // there is
                                                               // another
                                                               // division sign
                                                               // after the one
                                                               // we know about
                int i = 0;
                int pcounter = 0;
                while (num_string.charAt(i) != '/' || pcounter != 0) { // Moves
                                                                       // through
                                                                       // the
                                                                       // string
                                                                       // until
                                                                       // it
                                                                       // finds
                                                                       // the
                                                                       // '/' in
                                                                       // question,
                                                                       // done
                                                                       // by
                                                                       // counting
                    if (num_string.charAt(i) == '(') // parenthesis
                        pcounter++;
                    if (num_string.charAt(i) == ')')
                        pcounter--;
                    i++;
                }
                return (makeNumber(num_string.substring(0, i)) / makeNumber(num_string
                        .substring(i + 1))); // Calls make number on the
                                             // 'numerator' and
            } // 'denominator' of the string
            if (num_string.charAt(0) == '(') // If there are brackets around the
                                             // expression, removes them
                return makeNumber(num_string.substring(1, num_string.length() - 1));
            int i = 0;
            while (num_string.charAt(i) != '/')
                i++;
            return (makeNumber(num_string.substring(0, i)) / makeNumber(num_string.substring(i + 1))); // Calls
                                                                                                       // make
                                                                                                       // number
                                                                                                       // on
                                                                                                       // the
                                                                                                       // 'numerator'
                                                                                                       // and
        } // 'denominator' of the string
        int power = -1; // Sets the initial power to -1 as for every entry in
                        // the string we increment power by 1. i.e. string =
                        // "7", power = 0;
        double place_value = 0;
        double result = 0; // This array stores the 'numerator' and 'denominator'
                          // of the string
        int i = 0;
        while (i < num_string.length() && num_string.charAt(i) != '.') { // finds
                                                                         // the
                                                                         // part
                                                                         // of
                                                                         // the
                                                                         // string
                                                                         // that
                                                                         // represents
                                                                         // numbers
                                                                         // > 0
                                                                         // and
                                                                         // sets
            i++; // power to the appropriate number of digits to the right of
                 // the decimal
            power++; // point.
        }
        i = 0;
        while (i < num_string.length()) {
            place_value = Math.pow(10, power) * (num_string.charAt(i) - 48); // Finds
                                                                             // the
                                                                             // value
                                                                             // in
                                                                             // the
                                                                             // appropriate
                                                                             // place
                                                                             // corresponding
            if (place_value >= 0) // character in the string.
                result += place_value;
            else if (num_string.charAt(i) == '.') // If the character is the
                                                  // decimal we increment the
                                                  // power so that the next step
                                                  // will
                power++; // decrement it to -1, which is the first spot after
                         // the decimal
            i++;
            power--;
        }
        return result;
    }

    @Override
    public String toString() {// I know that it is a disaster but it's easy to
                              // figure out what it is doing, mostly just
                              // formatting to make it all look pretty.
        if(operator == '/')
            op1.open_bracket=op1.cls_bracket=op2.cls_bracket=op2.open_bracket=true;
        String result = "";
        if (open_bracket)
            result += "(";
        if (operator != 'a') {
            if (operator == '-' && op2.coe < 0.0f) {
                op2.coe = -op2.coe;
                operator = '+';
            }
            result += op1.toString() + operator + op2.toString();
        }
        else if (coe == 0)
            result += 0;
        else if (exp == 0)            
            if (coe == (int) coe)
                result += (int) coe;
            else
                result += coe;
        else if (fcn_name.equals("") && coe != 1 && coe != -1 && exp != 1) {
            if (coe == (int) coe)
                result += (int) coe;
            else
                result += coe;
            result += "x^";
            if (exp == (int) exp)
                result += (int) exp;
            else
                result += exp;
        }
        else if (fcn_name.equals("") && coe == 1 && exp != 1) {
            result += "x^";
            if (exp == (int) exp)
                result += (int) exp;
            else
                result += exp;
        }
        else if (fcn_name.equals("") && coe == -1 && exp != 1) {
            result += "-x^";
            if (exp == (int) exp)
                result += (int) exp;
            else
                result += exp;
        }
        else if (fcn_name.equals("") && coe == 1 && exp == 1) {
            result += "x";
        }
        else if (fcn_name.equals("") && coe == -1 && exp == 1) {
            result += "-x";
        }
        else if (fcn_name.equals("") && exp == 1) {
            if (coe == (int) coe)
                result += (int) coe;
            else
                result += coe;
            result += "x";
        }
        else {
            if (coe != 1 && coe != -1 && exp != 1) {
                if (coe == (int) coe)
                    result += (int) coe;
                else
                    result += coe;
                result += fcn_name + "^";
                if (exp == (int) exp)
                    result += (int) exp;
                else
                    result += exp;
                result += "(" + fcn_input.toString() + ")";
            }
            else if (coe == 1 && exp != 1) {
                result += fcn_name + "^";
                if (exp == (int) exp)
                    result += (int) exp;
                else
                    result += exp;
                result += "(" + fcn_input.toString() + ")";
            }
            else if (coe == -1 && exp != 1) {
                result += "-" + fcn_name + "^";
                if (exp == (int) exp)
                    result += (int) exp;
                else
                    result += exp;
                result += "(" + fcn_input.toString() + ")";
            }
            else if (coe == 1 && exp == 1) {
                result += fcn_name + "(" + fcn_input.toString() + ")";
            }
            else if (coe == -1 && exp == 1) {
                result += "-" + fcn_name + "(" + fcn_input.toString() + ")";
            }
            else if (exp == 1) {
                if (coe == (int) coe)
                    result += (int) coe;
                else
                    result += coe;
                result += fcn_name + "(" + fcn_input.toString() + ")";
            }
        }
        if (cls_bracket)
            result += ")";
        for (int i = 0; i < result.length() - 1; i++) {
            if (result.charAt(i) == '+' && result.charAt(i + 1) == '-')
                result = result.substring(0, i) + result.substring(i + 1);
        }
        String pi = ""+Math.PI;
        result = result.replace(pi, "π");
        String pi_2 = ""+Math.PI/2;
        result = result.replace(pi_2, "π/2");
        String pi_4 = ""+Math.PI/4;
        result = result.replace(pi_4, "π/4");
        return result;
    }

    public boolean equals(Expression original) {

        if (this.fcn_name == "") {
            if (this.op1 != null && original.op1 != null) {
                if (this.open_bracket == original.open_bracket &&
                        this.cls_bracket == original.cls_bracket &&
                        this.coe == original.coe &&
                        this.exp == original.exp &&
                        this.fcn_name.equals(original.fcn_name) &&
                        this.op1.equals(original.op1) &&
                        this.op2.equals(original.op2) &&
                        this.operator == original.operator)
                {
                    return true;
                }
            } else if (this.open_bracket == original.open_bracket &&
                    this.cls_bracket == original.cls_bracket &&
                    this.coe == original.coe &&
                    this.exp == original.exp &&
                    this.fcn_name.equals(original.fcn_name) &&
                    this.operator == original.operator)
            {
                return true;
            }

            return false;
        } else {
            if (this.open_bracket == original.open_bracket &&
                    this.cls_bracket == original.cls_bracket &&
                    this.coe == original.coe &&
                    this.exp == original.exp &&
                    this.fcn_name.equals(original.fcn_name) &&
                    this.fcn_input.equals(original.fcn_input) &&
                    this.operator == original.operator)
            {
                return true;
            }

            return false;
        }
    }

}
