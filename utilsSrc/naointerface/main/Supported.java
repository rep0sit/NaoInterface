package naointerface.main;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * 
 * This annotation interface is written just
 * to 'mark' certain Bodyparts that can be used as 
 * an argument for the constructor of the class {@code naointerface.main.Move}.
 * @author Nelli Welker
 * @author Etienne Onasch
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
@interface Supported {

}
