package naointerface.main;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * 
 * This annotation is written to mark fields in the utility class
 * {@code naointerface.main.BodyParts} that are no BodyParts.<br>
 * This is important so that reflective methods work correctly.
 * @author Nelli Welker
 * @author Etienne Onasch
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
@interface NoBodyPart {

}
