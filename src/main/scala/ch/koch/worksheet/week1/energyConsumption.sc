enum Network:
  case Mobile, Fixed

val dataCenterKwhPerMb: Double = 0.000072

val highDefinitionMbPerS = 0.6
val lowDefinitionMbPerS = 0.3

val co2PerKwh: Double = 0.5

val durationInS: Int = 30 * 60

val mobileKwhPerMb: Double = 0.00088
val fixedKwhPerMb: Double = 0.00043

def netWorkEnergyPerMb(network: Network): Double =
  network match
    case Network.Mobile => mobileKwhPerMb
    case Network.Fixed => fixedKwhPerMb

case class Experience(duration: Int, definition: Double, network: Network):
  def co2(): Double =
    duration * definition * netWorkEnergyPerMb(network) * co2PerKwh



val lowQualityFixedCo2 = Experience(durationInS, lowDefinitionMbPerS, Network.Fixed).co2()
val highQualityMobileCo2 = Experience(durationInS, highDefinitionMbPerS, Network.Mobile).co2()