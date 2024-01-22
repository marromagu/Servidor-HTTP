package ServerHTTP;

/**
 * ****************************************************************************
 * clase no instanciable donde se definen algunos valores finales
 *
 * @author IMCG
 */
public class Paginas {

    public static final String primeraCabecera
            = "Content-Type:text/html;charset=UTF-8";
    //contenido index
    public static final String html_index = "<html>"
            + "<head><title>index</title></head>"
            + "<body>"
            + "<h1>¡Enhorabuena!</h1>"
            + "<p>Tu servidor HTTP mínimo funciona correctamente</p>"
            + "<p><a href=\"http://localhost:8066/quijote\">El Quijote</a></p>"
            + "<p><a href=\"http://localhost:8066/formularioGet\">Formulario Get</a></p>"
            + "<p><a href=\"http://localhost:8066/formularioPost\">Formulario Post</a></p>"
            + "<p><a href=\"http://localhost:8066/formularioRespuesta\">Respuesta</a></p>"
            + "</body>"
            + "</html>";
    //contenido quijote
    public static final String html_quijote = "<html>"
            + "<head><title>quijote</title></head>"
            + "<body>"
            + "<h1>Así comienza el Quijote</h1>"
            + "<p>En un lugar de la Mancha, de cuyo nombre no quiero "
            + "acordarme, no ha mucho tiempo que vivía un hidalgo de los "
            + "de lanza en astillero, adarga antigua, rocín flaco y galgo "
            + "corredor. Una olla de algo más vaca que carnero, salpicón "
            + "las más noches, duelos y quebrantos (huevos con tocino) los "
            + "sábados, lentejas los viernes, algún palomino de añadidura "
            + "los domingos, consumían las tres partes de su hacienda. El "
            + "resto della concluían sayo de velarte (traje de paño fino), "
            + "calzas de velludo (terciopelo) para las fiestas con sus "
            + "pantuflos de lo mismo, y los días de entresemana se honraba "
            + "con su vellorí (pardo de paño) de lo más fino. Tenía en su "
            + "casa una ama que pasaba de los cuarenta, y una sobrina que "
            + "no llegaba a los veinte, y un mozo de campo y plaza, que "
            + "así ensillaba el rocín como tomaba la podadera...</p>"
            + "</body>"
            + "</html>";
    //Fomulario por GET
    public static final String html_GET = "<html>"
            + "<head>"
            + "    <title>Formulario Get</title>"
            + "</head>"
            + "<body>"
            + "    <form action=\"formularioRespuesta\" method=\"get\" id=\"miFormulario\">"
            + "        <label for=\"nombre\">Nombre:</label>"
            + "        <input type=\"text\" id=\"nombre\" name=\"nombre\" required>"
            + "        <label for=\"numeroMultiplica\">Número a multiplicar:</label>"
            + "        <input type=\"number\" id=\"numeroMultiplica\" name=\"numeroMultiplica\" required>"
            + "        <button type=\"submit\">Enviar</button>"
            + "    </form>"
            + "</body>"
            + "</html>";
    //Fomulario por GET
    public static final String html_POST = "<html>"
            + "<head>"
            + "    <title>Formulario Post</title>"
            + "</head>"
            + "<body>"
            + "    <form action=\"formularioRespuesta\" method=\"post\" id=\"miFormulario\">"
            + "        <label for=\"nombre\">Nombre:</label>"
            + "        <input type=\"text\" id=\"nombre\" name=\"nombre\" required>"
            + "        <label for=\"numeroMultiplica\">Número a multiplicar:</label>"
            + "        <input type=\"number\" id=\"numeroMultiplica\" name=\"numeroMultiplica\" required>"
            + "        <button type=\"submit\">Enviar</button>"
            + "    </form>"
            + "</body>"
            + "</html>";
    //Fomulario por GET
    public static final String html_Respuesta = "<html>"
            + "<head>"
            + "    <title>Formulario Post</title>"
            + "</head>"
            + "<body>"
            +"<h1>RESPUESTA</h1>"
            + "</body>"
            + "</html>";
    //contenido noEncontrado
    public static final String html_noEncontrado = "<html>"
            + "<head><title>noEncontrado</title></head>"
            + "<body>"
            + "<h1>¡ERROR! Página no encontrada</h1>"
            + "<p>La página que solicitaste no existe en nuestro "
            + "servidor</p>"
            + "</body>"
            + "</html>";
}
