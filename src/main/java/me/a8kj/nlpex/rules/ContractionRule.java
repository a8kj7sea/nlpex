package me.a8kj.nlpex.rules;

import me.a8kj.mattc.token.Token;
import me.a8kj.mattc.token.impl.LexerToken;
import me.a8kj.mattc.token.attributes.TokenLocation;
import me.a8kj.mattc.tokenizer.attributes.TokenizerApplyResult;
import me.a8kj.mattc.tokenizer.attributes.TokenizerRule;
import me.a8kj.mattc.tokenizer.context.TokenizerContext;
import me.a8kj.nlpex.category.NLPCategory;


public class ContractionRule implements TokenizerRule {

    @Override
    public boolean matches(TokenizerContext context) {
        if (!context.hasNext()) return false;
        char c = context.currentChar();
        return Character.isLetter(c);
    }

    @Override
    public TokenizerApplyResult apply(TokenizerContext context) {
        int start = context.getPosition();
        int line = context.getLine();
        int column = context.getColumn();

        StringBuilder builder = new StringBuilder();

        while (context.hasNext()) {
            char c = context.currentChar();
            if (Character.isLetter(c)) {
                builder.append(c);
                context.advance();
            } else if (c == '\'') {
                builder.append(c);
                context.advance();
            } else {
                break;
            }
        }

        String value = builder.toString();
        TokenLocation location = new TokenLocation(column, line, start, context.getPosition());
        Token token = new LexerToken(value, NLPCategory.CONTRACTION, location);

        return TokenizerApplyResult.success(token);
    }
}
