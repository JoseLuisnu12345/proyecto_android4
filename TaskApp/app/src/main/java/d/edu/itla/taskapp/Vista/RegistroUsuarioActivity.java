package d.edu.itla.taskapp.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import d.edu.itla.taskapp.R;
import d.edu.itla.taskapp.entidad.Categoria;
import d.edu.itla.taskapp.entidad.Usuario;
import d.edu.itla.taskapp.Repositorio.UsuarioRepositorioDbImpl;
import d.edu.itla.taskapp.Repositorio.UsuarioRepositorio;

import java.util.List;

import se.simbio.encryption.Encryption;

public class RegistroUsuarioActivity extends AppCompatActivity {

    private static final String LOG_TAG = "RegistroUsuarioActivity";
    private UsuarioRepositorio usuarioRepositorio;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        //text
        final EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
        final EditText txtContrasena = (EditText) findViewById(R.id.txtPassword);
        final EditText txtRepetirContrasena = (EditText) findViewById(R.id.txtRepetirPassword);
        final RadioButton rdoBtnTecnico = (RadioButton) findViewById(R.id.rdoBtnTecnico);
        final RadioButton rdoBtnNormal = (RadioButton) findViewById(R.id.rdoBtnNormal);

        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrarse);
        Button btnCancelar = (Button) findViewById(R.id.btnCancelar);

        //on click
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    usuarioRepositorio = new UsuarioRepositorioDbImpl(getApplicationContext());
                    List<Usuario> usuarioList = usuarioRepositorio.buscar(txtEmail.getText().toString());

                    if (usuarioList.size() > 0) {
                        //mensaje
                        Toast toast = Toast.makeText(getApplicationContext(), "Este Email ya existe en la base de datos, favor de iniciar sesión.", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }
                    //registrar un usuario
                    boolean nuevo = false;

                    if (usuario == null) {
                        nuevo = true;
                        usuario = new Usuario();
                    }
                    //email
                    usuario.setEmail(txtEmail.getText().toString());
                    //nombre
                    usuario.setNombre(txtNombre.getText().toString());

                    String contrasena = txtContrasena.getText().toString();
                    String repetirContrasena = txtRepetirContrasena.getText().toString();
                    if (contrasena.equals(repetirContrasena)) {
                        Encryption encryption = Encryption.getDefault("Jose", "Luis", new byte[16]);
                        String encrypted = encryption.encryptOrNull(txtContrasena.getText().toString());
                        usuario.setContraseña(encrypted);
                    } else {
                        //mensaje
                        Toast toast = Toast.makeText(getApplicationContext(), "Contraseña y Repetir Contraseña no coinciden.", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }
                    //log
                    Log.i(LOG_TAG, usuario.toString());

                    if (nuevo) {
                        //guardar
                        usuarioRepositorio.guardar(usuario);
                        //log
                        Log.i(LOG_TAG, usuario.toString());
                        //mensaje
                        Toast toast = Toast.makeText(getApplicationContext(), "Guardado correctamente.", Toast.LENGTH_SHORT);
                        //toast1.setGravity(Gravity.CENTER,,);
                        toast.show();
                        //en blanco luego de guardar
                        txtNombre.setText("");
                    } else {
                        usuarioRepositorio.actualizar(usuario);
                        //mensaje
                        Toast toast = Toast.makeText(getApplicationContext(), "Usuario Actualizado correctamente.", Toast.LENGTH_SHORT);
                        //toast1.setGravity(Gravity.CENTER,,);
                        toast.show();
                        //intent
                        Intent registrarUsuarioIntent = new Intent(RegistroUsuarioActivity.this, LoginActivity.class);
                        startActivity(registrarUsuarioIntent);
                    }
                }catch (Exception ex)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error: " + ex.toString(), Toast.LENGTH_LONG);
                    toast.show();
                }

                //Encryption encryption = Encryption.getDefault("Jose", "LUIS", new byte[16]);
                //String encrypted = encryption.encryptOrNull("password a encryptar");
                //String decrypted = encryption.decryptOrNull(encrypted);

            }//end onclick
        });//end setonclick

        //on click
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent
                Intent registrarseIntent = new Intent(RegistroUsuarioActivity.this, LoginActivity.class);
                startActivity(registrarseIntent);

            }
        });
    }
}

