package cartesian

object Orderer {
  def counterclockwise(points: Seq[Point]): Seq[Point] = {
    def polarAngle(x: Int, y: Int): Double = {
      Math.toDegrees(Math.atan(y.toDouble / x.toDouble))
    }

    points.sortBy(_.y) match {
      case head :: tail => {
        head :: tail.map(p => {
          val x = p.x - head.x
          val y = p.y - head.y

          if (x >= 0 && y >= 0) (p, polarAngle(x, y))
          else if (x >= 0) (p, polarAngle(x, y) + 360)
          else (p, polarAngle(x, y) + 180)
        })
          .sortBy(_._2)
          .map(_._1)
      }
    }
  }
}
