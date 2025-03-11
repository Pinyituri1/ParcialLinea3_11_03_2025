package org.example;

import java.util.ArrayList;

public class CabinaTelefonica {
    private int tarifaLocal = 50;
    private int tarifaLargaDistancia = 350;
    private int tarifaCelular = 150;
    private String idCabina;
    private int totalLlamadas;
    private int totalMinutos;
    private int totalCosto;
    private ArrayList<String> historial = new ArrayList<>(); // Historial de llamadas

    public CabinaTelefonica(String idCabina) {
        this.idCabina = idCabina;
        this.totalLlamadas = 0;
        this.totalMinutos = 0;
        this.totalCosto = 0;
    }

    public String getIdCabina() {
        return idCabina;
    }

    public void registrarLlamada(String tipo, int duracion) {
        int costo = 0;
        switch (tipo.toLowerCase()) {
            case "local":
                costo = tarifaLocal * duracion;
                break;
            case "larga_distancia":
                costo = tarifaLargaDistancia * duracion;
                break;
            case "celular":
                costo = tarifaCelular * duracion;
                break;
            default:
                System.out.println(" Tipo de llamada no válido.");
                return;
        }
        totalLlamadas++;
        totalMinutos += duracion;
        totalCosto += costo;
        historial.add(tipo + " - " + duracion + " min - $" + costo); // Agregar al historial
        System.out.println(" Llamada registrada correctamente.");
    }

    public void reiniciarCabina() {
        totalLlamadas = 0;
        totalMinutos = 0;
        totalCosto = 0;
        historial.clear(); // Borrar historial
        System.out.println(" Cabina reiniciada con éxito.");
    }

    public String obtenerInforme() {
        String informe = "\n Cabina: " + idCabina +
                "\n Llamadas realizadas: " + totalLlamadas +
                "\n Duración total: " + totalMinutos + " minutos" +
                "\n Costo total: $" + totalCosto +
                "\n Historial de llamadas:";

        for (String llamada : historial) {
            informe += "\n   " + llamada;
        }

        return informe;
    }
}
