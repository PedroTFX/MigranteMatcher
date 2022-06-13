package main.java.Voluntario;

public class Voluntario {
    private int contacto, codigo;

    public Voluntario(int contacto){
        this.contacto = contacto;
    }

    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo) {
    	this.codigo = codigo;
    }

    public boolean verifySMS(int codigo, int cod){
        return codigo == cod;
    }

    public void createVoluntario(int contacto){
        CatalogoVoluntarios.addNewVol(contacto);
    }

    public int getContacto(){
        return contacto;
    }
}

