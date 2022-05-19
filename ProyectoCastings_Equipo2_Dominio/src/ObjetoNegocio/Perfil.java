/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetoNegocio;

import org.bson.types.ObjectId;

/**
 *
 * @author acedo
 */
public class Perfil {

    private ObjectId id;
    private String estado;
    private String sexo;
    private String colorPelo;
    private String colorOjos;
    private boolean experiencia;
    private String especialidad;
    private String rangoEdad;
    private String rangoAltura;
    private ObjectId CastingDueno;

    public Perfil() {
    }

   

    public Perfil(ObjectId id, String estado, String sexo, String colorPelo, String colorOjos, boolean experiencia, String especialidad, String rangoEdad, String rangoAltura, ObjectId CastingDueno) {
        this.id = id;
        this.estado = estado;
        this.sexo = sexo;
        this.colorPelo = colorPelo;
        this.colorOjos = colorOjos;
        this.experiencia = experiencia;
        this.especialidad = especialidad;
        this.rangoEdad = rangoEdad;
        this.rangoAltura = rangoAltura;
        this.CastingDueno = CastingDueno;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public boolean isExperiencia() {
        return experiencia;
    }

    public void setExperiencia(boolean experiencia) {
        this.experiencia = experiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(String rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public String getRangoAltura() {
        return rangoAltura;
    }

    public void setRangoAltura(String rangoAltura) {
        this.rangoAltura = rangoAltura;
    }

    public void validarDatos(Perfil perfil) {

        if (perfil.getSexo().trim().length() == 0 || perfil.getColorOjos().trim().length() == 0 || perfil.getColorPelo().trim().length() == 0 || perfil.getEspecialidad().trim().length() == 0
                || perfil.getEstado().trim().length() == 0 || perfil.getRangoAltura().trim().length() == 0 || perfil.getRangoEdad().trim().length() == 0) {
            throw new RuntimeException("Datos incompletos");
        }

    }

    public ObjectId getCastingDueno() {
        return CastingDueno;
    }

    public void setCastingDueno(ObjectId CastingDueno) {
        this.CastingDueno = CastingDueno;
    }

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", estado=" + estado + ", sexo=" + sexo + ", colorPelo=" + colorPelo + ", colorOjos=" + colorOjos + ", experiencia=" + experiencia + ", especialidad=" + especialidad + ", rangoEdad=" + rangoEdad + ", rangoAltura=" + rangoAltura + '}';
    }

}
