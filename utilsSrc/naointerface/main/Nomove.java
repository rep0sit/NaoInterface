package naointerface.main;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * This is an annotation for BodyParts, that should not be moved <br>
 * with methods from the class naointerface.main.Moves.<br>
 * This can be due to safety reasons or because the BodyPart cannot be <br>
 * a parameter for the ALMotion.angleInterpolation(...) Method of NaoQi.
 * @author Etienne Onasch
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
@interface Nomove {

}
