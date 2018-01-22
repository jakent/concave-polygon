package cartesian

object Orderer {
  def counterclockwise(points: Seq[Point]): Seq[Point] = {
    points.sortBy(_.y) match {
      case head :: tail => {
        head :: tail.map(p => (p, p.polarAngle(head)))
          .sortBy(p => (p._2, Point.distance(head, p._1)))
          .map(_._1)
      }
    }
  }
}
