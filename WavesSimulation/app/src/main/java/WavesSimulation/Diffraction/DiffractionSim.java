package WavesSimulation.Diffraction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The math part of Diffraction
 *
 * @author KarenFl
 */
@NoArgsConstructor
@Getter
@Setter
public class DiffractionSim {
    private static final double LENGTH_TO_SCREEN = 5.0;

    private double diffractionAngle;
    private double diffractionRadius;

    /**
     * calculates the angle according to the equation: dsin(angle)=
     * (orderNum)(wavelength)
     *
     * @param wavelength
     * @param slitDistance
     * @param orderNum
     * @return angle
     */
    public double calculationAngle(int wavelength, double slitDistance, int orderNum) {
        double sinOfAngle = (Math.pow(10, -4) * wavelength * orderNum) / slitDistance;
        diffractionAngle = Math.toDegrees(Math.asin(sinOfAngle));

        return diffractionAngle;
    }

    /**
     * Calculates the radius according to the equation: y=Ltan(angle)
     *
     * @return radius
     */
    public double calculationDiffractionRadius() {
        diffractionRadius = LENGTH_TO_SCREEN * Math.tan(getDiffractionAngle());

        return diffractionRadius;
    }

}
