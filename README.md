<<<<<<< HEAD
## sbt project compiled with Dotty

### Usage

This is a normal sbt project, you can compile code with `sbt compile` and run it
with `sbt run`, `sbt console` will start a Dotty REPL.

For more information on the sbt-dotty plugin, see the
[dotty-example-project](https://github.com/lampepfl/dotty-example-project/blob/master/README.md).
=======
# animal-shogi-server

どうぶつしょうぎサーバー

https://ja.wikipedia.org/wiki/どうぶつしょうぎ
これをネット対戦できるようにしたい

## プロジェクト構成

ドメイン駆動とかクリーンアーキテクチャとかそういうイケイケの設計方針を守ろうね
よく分かっていませんが

あのタマネギの中心のやつはクリーンアーキテクチャでは「エンティティ」と呼ばれているけど（「企業全体の最重要ビジネスルールをカプセル化したもの」 Clean Architecture p201)、
ドメイン駆動のあの本のエンティティ（「同一性によって定義されるオブジェクト」 DDD p89）と紛らわしいので、ここでは `domain` と名付けておく

```
/domain/rules - どうぶつしょうぎのルールをコードで書く(最初に書く)
/usecase
/interface
/framework

/root - 全体をコンパイルしたりテストしたりするだけに使う
```
>>>>>>> master
