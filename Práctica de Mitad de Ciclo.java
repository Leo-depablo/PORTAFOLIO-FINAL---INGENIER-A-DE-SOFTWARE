import java.util.*;

class Autenticacion {
    private static Autenticacion instancia;
    private Map<String, Usuario> usuariosRegistrados = new HashMap<>();
    private List<Recurso> recursosDisponibles = new ArrayList<>();

    private Autenticacion() {}

    public static Autenticacion getInstancia() {
        if (instancia == null) {
            instancia = new Autenticacion();
        }
        return instancia;
    }

    public boolean verificarCredenciales(String nombre, String contrasena) {
        Usuario usuario = usuariosRegistrados.get(nombre);
        return usuario != null && usuario.verificarContrasena(contrasena);
    }
}

class Usuario {
    private int idUsuario;
    private String nombre;
    private String contrasena;
    private int intentosFallidos;

    public boolean estaBloqueado() {
        return intentosFallidos >= 3;
    }

    public boolean verificarContrasena(String contrasena) {
        if (this.contrasena.equals(contrasena)) {
            reiniciarIntentos();
            return true;
        } else {
            incrementarIntentos();
            return false;
        }
    }

    private void reiniciarIntentos() {
        intentosFallidos = 0;
    }

    private void incrementarIntentos() {
        intentosFallidos++;
    }
}

abstract class Recurso {
    protected int idUsuario;
    protected String nombre;
    protected Set<Usuario> usuariosAutorizados = new HashSet<>();

    public void agregarUsuario(Usuario usuario) {
        usuariosAutorizados.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuariosAutorizados.remove(usuario);
    }

    public boolean verificarAcceso(Usuario usuario) {
        return usuariosAutorizados.contains(usuario);
    }
}

class Archivo extends Recurso {
    private String tipoArchivo;
    private float tamano;
    private String nivel;

    public void descargar() {
        System.out.println("Descargando archivo...");
    }
}

class Servicio extends Recurso {
    private String estado;
    private String nivel;

    public void iniciar() {
        estado = "Iniciado";
    }

    public void detener() {
        estado = "Detenido";
    }
}

class App extends Recurso {
    private String version;
    private String nivel;

    public void ejecutar() {
        System.out.println("Ejecutando aplicación...");
    }

    public void detener() {
        System.out.println("Deteniendo aplicación...");
    }
}

class RecursoFactory {
    public static Recurso crearRecurso(String tipo) {
        switch (tipo) {
            case "Archivo":
                return new Archivo();
            case "Servicio":
                return new Servicio();
            case "App":
                return new App();
            default:
                throw new IllegalArgumentException("Tipo de recurso no válido");
        }
    }
}
