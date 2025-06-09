package me.a8kj.nlpex.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.mattc.token.attributes.TokenCategory;

@RequiredArgsConstructor
@Getter
public enum NLPCategory implements TokenCategory {
    WHITESPACE("WHITESPACE"),
    WORD("WORD"),
    NUMBER("NUMBER"),
    PUNCTUATION("PUNCTUATION"),
    CONTRACTION("CONTRACTION");

    private final String value;

    @Override
    public String value() {
        return value;
    }
}
