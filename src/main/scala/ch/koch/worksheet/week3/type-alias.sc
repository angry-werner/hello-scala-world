type UserID = Long
object UserId:
  def parse(idAsString: String): Option[UserID] =
    idAsString.toLongOption

UserId.parse("123").get

123l == UserId.parse("123").get

object UserID:
  opaque type UserID = Long
  def parse(aUserIdAsString: String): Option[UserID] = aUserIdAsString.toLongOption
  def value(aUserId: UserID): String = aUserId.toString
  extension (userId: UserID)
    def betterValue: Long = userId

object VehicleId:
  opaque type VehicleId = Long

val userId: UserID.UserID = UserID.parse("123").get

UserID.value(aUserId = userId)

import UserID.UserID
userId.betterValue

extension (basis: Int)
  def ** (potenz: Int): Int = List.fill(potenz)(basis).product

2 ** 3

**(2)(3)

object Lengths:
  opaque type Meters = Double
  def Meters(value: Double): Meters = value
  extension (x: Meters)
    def + (y: Meters): Meters = x + y
    def show: String = s"$x m"
