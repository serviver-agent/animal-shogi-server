# domain-rules

https://ja.wikipedia.org/wiki/どうぶつしょうぎ
これをもうちょっと丁寧に噛み砕いたのをここにちゃんと書く

## 駒を動かすには

* 将棋盤の上から自分の手番の駒を一つ選ぶ
* 駒の動き一覧を取得する
* 上記のうち将棋盤の上で範囲外のものを除く
* 上記のうち自分の手番の駒が存在するものを除く
* (将棋と異なり、ライオンが王手になる位置に動かしても良い)