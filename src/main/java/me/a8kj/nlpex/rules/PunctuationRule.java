package me.a8kj.nlpex.rules;

import me.a8kj.mattc.token.Token;
import me.a8kj.mattc.token.impl.LexerToken;
import me.a8kj.mattc.token.attributes.TokenLocation;
import me.a8kj.mattc.tokenizer.attributes.TokenizerApplyResult;
import me.a8kj.mattc.tokenizer.attributes.TokenizerRule;
import me.a8kj.mattc.tokenizer.context.TokenizerContext;
import me.a8kj.nlpex.category.NLPCategory;

public class PunctuationRule implements TokenizerRule {

    private static final String PUNCTUATIONS = ".,!?";

    @Override
    public boolean matches(TokenizerContext context) {
        return context.hasNext() && PUNCTUATIONS.indexOf(context.currentChar()) >= 0;
    }

    @Override
    public TokenizerApplyResult apply(TokenizerContext context) {
        int start = context.getPosition();
        int line = context.getLine();
        int column = context.getColumn();

        char c = context.currentChar();
        context.advance();

        TokenLocation location = new TokenLocation(column, line, start, context.getPosition());
        Token token = new LexerToken(String.valueOf(c), NLPCategory.PUNCTUATION, location);

        return TokenizerApplyResult.success(token);
    }
}
