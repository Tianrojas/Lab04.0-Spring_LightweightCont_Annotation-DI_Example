package edu.eci.arsw.springdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;


public class GrammarCheckerTest {

    public String performGrammarCheckSpanish(String texto) {
        return "Spell checking output: " + "revisando ("+texto+") con el verificador de sintaxis del espanol. " + " Plagiarism checking output: Not available yet";
    }

    public String performGrammarCheckEnglish(String texto) {
        return "Spell checking output: " + "Checked with english checker: "+texto+ " Plagiarism checking output: Not available yet";
    }

    @Test
    public void testGrammarCheck() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GrammarChecker gc  = context.getBean(GrammarChecker.class);
        String texto = "Este es un ejemplo de verificación gramatical en Spring.";
        String resultado = gc.check(texto);
        assertEquals(resultado, performGrammarCheckEnglish(texto));
    }

}
