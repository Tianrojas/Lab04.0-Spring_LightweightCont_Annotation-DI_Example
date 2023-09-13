package edu.eci.arsw.springdemo.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.eci.arsw.springdemo.GrammarChecker;
import org.springframework.stereotype.Controller;

@Controller
public class GrammarCheckerTest {

    public static void performGrammarCheckSpanish(String texto, GrammarChecker gc) {
        String resultado = gc.check(texto);
        System.out.println(resultado.equals("Spell checking output: " + "revisando ("+texto+") con el verificador de sintaxis del espanol. " + " Plagiarism checking output: Not available yet") ? "Prueba superada" : "Prueba NO superada");
    }

    public static void performGrammarCheckEnglish(String texto, GrammarChecker gc) {
        String resultado = gc.check(texto);
        System.out.println(resultado.equals("Spell checking output: " + "Checked with english checker: "+texto+ " Plagiarism checking output: Not available yet") ? "Prueba superada" : "Prueba NO superada");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GrammarChecker gc  = context.getBean(GrammarChecker.class);
        String texto = "Este es un ejemplo de verificación gramatical en Spring.";
        performGrammarCheckEnglish(texto, gc );
    }
}
