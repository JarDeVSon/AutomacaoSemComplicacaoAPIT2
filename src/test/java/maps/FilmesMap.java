package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmesMap {
    private static Map<String, String> header;
    private static Map<String, Object> filme;
    private static Map<String, Object> categoria1, categoria2, plataforma;
    private static List<Map<String, Object>> listCategoria, listPlataforma;
    public static int id;

    public static Map<String, String> getHeader() {
        return header;
    }

    public static Map<String, Object> getFilme() {
        return filme;
    }

    public static Map<String, Object> getCategoria1() {
        return categoria1;
    }

    public static Map<String, Object> getCategoria2() {
        return categoria2;
    }

    public static Map<String, Object> getPlataforma() {
        return plataforma;
    }


    public static List<Map<String, Object>> getListCategoria() {
        return listCategoria;
    }

    public static List<Map<String, Object>> getListPlataforma() {
        return listPlataforma;
    }

    public static void initHeader() {
        header = new HashMap<>();
        header.put("Authorization", "Bearer " + LoginMap.token);
    }

    public static void initCategorias() {
        listCategoria = new ArrayList<>();
        categoria1 = new HashMap<>();
        categoria2 = new HashMap<>();
        categoria1.put("tipo", "Acao");
        categoria2.put("tipo", "Comedia");
        listCategoria.add(categoria1);
        listCategoria.add(categoria2);

    }

    public static void initPlataformas() {
        listPlataforma = new ArrayList<>();
        plataforma = new HashMap<>();
        plataforma.put("nome", "NetFlix");
        listPlataforma.add(plataforma);
    }

    public static void initFilme() {
        filme = new HashMap<>();
        filme.put("nome", "Adao Negro porradeiro");
        filme.put("descricao", "Adao Negro e o filme solo do anti-heroi, " +
                "baseado no personagem em quadrinhos Black Adam (Dwayne Johnson) da DC Comics, grande antagonista de Shazam!");
        filme.put("duracao", 2.05);
        filme.put("categorias", listCategoria);
        filme.put("plataformas", listPlataforma);
    }

    public static void initAll() {
        initHeader();
        initCategorias();
        initPlataformas();
        initFilme();
    }
}
