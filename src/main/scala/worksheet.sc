val a = List(1, 2)

a :+ a.head

a.last +: a :+ a.head


def toCoolString(a: Int, b: Int, c: Int): String = {
  a.toString + b.toString + c.toString
}

def loop(l: Seq[Int], acc: Seq[String]): Seq[String] = l match {
  case f :: s :: t :: tail => loop(s :: t :: tail, acc :+ toCoolString(f, s, t))
  case _ => acc
}

loop(a.last +: a :+ a.head, Nil)