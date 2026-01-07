# nlpex 
An example on 'Mattc' tokenizer

# Output


```c
========== Tokens ==========
Value                | Category        | Location
-------------------------------------------------------------
I                    | WORD            | Line 1, Col 1 [0..1]
m                    | WORD            | Line 1, Col 3 [2..3]
                     | WHITESPACE      | Line 1, Col 4 [3..4]
akj                  | WORD            | Line 1, Col 5 [4..7]
                     | WHITESPACE      | Line 1, Col 8 [7..8]
,                    | PUNCTUATION     | Line 1, Col 9 [8..9]
                     | WHITESPACE      | Line 1, Col 10 [9..10]
and                  | WORD            | Line 1, Col 11 [10..13]
                     | WHITESPACE      | Line 1, Col 14 [13..14]
hello                | WORD            | Line 1, Col 15 [14..19]
                     | WHITESPACE      | Line 1, Col 20 [19..20]
world                | WORD            | Line 1, Col 21 [20..25]
                     | WHITESPACE      | Line 1, Col 26 [25..26]
!                    | PUNCTUATION     | Line 1, Col 27 [26..27]

========== Errors ==========
? Unknown character: '''

========== Tokens ==========
Value                | Category        | Location
-------------------------------------------------------------
bye                  | WORD            | Line 1, Col 1 [0..3]
```
