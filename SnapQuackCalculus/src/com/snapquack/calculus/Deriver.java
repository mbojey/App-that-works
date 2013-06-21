package com.snapquack.calculus;


public class Deriver {
	/*
	 * purpose: to differentiate an expression, this class only determines the
	 * type of Expression and then calls the appropriate method to do the work
	 * i.e. chain rule, sum rule, product rule etc.
	 */
	public static Expression derive(Expression original) {
		if (original.fcn_name != "") {
			return chainRule(original);
		}
		if (original.operator == 'a')
			return powerRule(original);
		switch (original.operator) {
		case ('+'):
			return sumRule(original);
		case ('-'):
			return sumRule(original);
		case ('/'):
			return quotientRule(original);
		case ('*'):
			return productRule(original);
		case ('^'):
			return exponentRule(original);
		}
		return null;
	}

	public static Expression productRule(Expression original) {
		Expression f_prime_g = new Expression();
		Expression g_prime_f = new Expression();
		f_prime_g.op1 = derive(original.op1);
		f_prime_g.op2 = original.op2;
		f_prime_g.operator = '*';
		g_prime_f.op2 = derive(original.op2);
		g_prime_f.op1 = original.op1;
		g_prime_f.operator = '*';
		Expression result = new Expression(f_prime_g, '+', g_prime_f);
		return result;
	}

	public static Expression quotientRule(Expression original) {
		Expression f_prime = derive(original.op1);
		Expression g = original.op2;
		Expression g_prime = derive(original.op2);
		Expression f = original.op1;
		g.cls_bracket = g.open_bracket = true;
        f.cls_bracket = f.open_bracket = true;
        g_prime.cls_bracket = g_prime.open_bracket = true;
        f_prime.cls_bracket = f_prime.open_bracket = true;
		Expression f_prime_g = new Expression(f_prime, '*', g);
		Expression g_prime_f = new Expression(g_prime, '*', f);
		Expression g_squared = new Expression(g, '*', g);
		g_squared.cls_bracket = g_squared.open_bracket = true;
		Expression top = new Expression(f_prime_g, '-', g_prime_f);
		top.cls_bracket = top.open_bracket = true;
		Expression result = new Expression(top, '/', g_squared);
		return result;
	}

	public static Expression sumRule(Expression original) {
		Expression temp1 = derive(original.op1);
		temp1.open_bracket = temp1.cls_bracket = false;
		Expression temp2 = derive(original.op2);
		temp2.open_bracket = temp2.cls_bracket = false;
		Expression result = new Expression(temp1, original.operator, temp2);
		return result;
	}

	public static Expression powerRule(Expression original) {
		Expression result = new Expression(original);
		result.coe = original.coe * original.exp;
		result.exp--;
		return result;

	}

	public static Expression chainRule(Expression original) {
		Expression temp1 = Function_derive(original);
		temp1.cls_bracket = temp1.open_bracket = true;

		Expression temp2 = derive(original.fcn_input);
		temp2.cls_bracket = temp2.open_bracket = true;

		Expression result = new Expression(temp1, '*', temp2);
		return result;
	}
	public static Expression exponentRule(Expression original) {
        Expression bracketed_original = new Expression(original);
        bracketed_original.cls_bracket = bracketed_original.open_bracket = true;
        Expression exponent = new Expression(original.op2);
        exponent.cls_bracket=exponent.open_bracket=true;
        Expression base = new Expression(original.op1);
        base.cls_bracket = base.open_bracket = true;
        Expression exp_derived = derive(exponent);
        exp_derived.open_bracket=exp_derived.cls_bracket=true;
        Expression base_derived = derive(base);
        base_derived.open_bracket=base_derived.cls_bracket=true;
        Expression exponent_less_1 = new Expression(exponent, '-', new Expression(1,0));
        exponent_less_1.cls_bracket = exponent_less_1.open_bracket = true;
        Expression ln_base = new Expression("ln",base);
        ln_base.cls_bracket=ln_base.open_bracket=true;
        Expression base_pow_exp_less_1 = new Expression(base, '^', exponent_less_1);
        base_pow_exp_less_1.open_bracket=base_pow_exp_less_1.cls_bracket=true;
        Expression base_der_times_exponent = new Expression(base_derived, '*', exponent);
        base_der_times_exponent.open_bracket=base_der_times_exponent.cls_bracket=true;
        Expression sum1 = new Expression(base_pow_exp_less_1, '*', base_der_times_exponent);
        sum1.cls_bracket = sum1.open_bracket = true;
        Expression ln_base_times_exp_der = new Expression(exp_derived, '*', ln_base);
        ln_base_times_exp_der.cls_bracket=ln_base_times_exp_der.open_bracket=true;
        Expression sum2 = new Expression(bracketed_original, '*', ln_base_times_exp_der);
        sum2.cls_bracket = sum2.open_bracket = true;
        Expression result = new Expression(sum1, '+', sum2);
        return result;      
    }	

	public static Expression Function_derive(Expression original) {
        if (original.fcn_name.equals("sin"))
            return new Expression(original.coe + "cos" + '('
                    + original.fcn_input.toString() + ')');
        else if (original.fcn_name.equals("cos"))
            return new Expression(-original.coe + "sin" + '('
                    + original.fcn_input.toString() + ')');
        else if (original.fcn_name.equals("tan"))
            return new Expression("(" + original.coe + "sec" + "("
                    + original.fcn_input.toString() + ')' + ")^" + 2);
        else if (original.fcn_name.equals("ln"))
            return new Expression("" + original.coe + "/("
                    + original.fcn_input.toString() + ")");
        else if (original.fcn_name.equals("exp"))
            return original;
        else if (original.fcn_name.equals("arcsin"))
            return new Expression(original.coe + "/((1-" + "("
                    + original.fcn_input.toString() + ")" + "^2)^.5)");
        else if (original.fcn_name.equals("arccos"))
            return new Expression(-original.coe + "/((1-" + "("
                    + original.fcn_input.toString() + ")" + "^2)^.5)");
        else if (original.fcn_name.equals("arctan"))
            return new Expression(original.coe + "/(1+" + "("
                    + original.fcn_input.toString() + ")" + "^2)");
        else if (original.fcn_name.equals("csc"))
            return new Expression(-original.coe + "cot("
                    + original.fcn_input.toString() + ")*csc("
                    + original.fcn_input.toString() + ")");
        else if (original.fcn_name.equals("cot"))
            return new Expression("(" + -original.coe + "csc" + '('
                    + original.fcn_input.toString() + ')' + ")^" + 2.0f);
        else if (original.fcn_name.equals("sec"))
            return new Expression(original.coe + "tan("
                    + original.fcn_input.toString() + ")*sec("
                    + original.fcn_input.toString() + ")");
        else if (original.fcn_name.equals("arccsc"))
            return new Expression(-original.coe + "/("
                    + original.fcn_input.toString() + "*("
                    + original.fcn_input.toString() + "^2-1)^.5)");
        else if (original.fcn_name.equals("arccot"))
            return new Expression(-original.coe + "/(1+" + "("
                    + original.fcn_input.toString() + ")" + "^2)");
        else if (original.fcn_name.equals("arcsec"))
            return new Expression(original.coe + "/("
                    + original.fcn_input.toString() + "*("
                    + original.fcn_input.toString() + "^2-1)^.5)");
        return null;
    }
	
}
