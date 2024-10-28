import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Policia> policias = new ArrayList<>();
        ArrayList<Corta> armascortas = new ArrayList<>();
        ArrayList<Larga> armaslargas = new ArrayList<>();
        Menu_Base menuBase = new Menu_Base();
        int opcion;
        String nombre;
        String nombreFormateado;
        String apellido;
        String apellidoFormateado;
        int legajo;
        int cantMuniciones;
        double alcance;
        String marca;
        String marcaFormateada;
        int calibre;
        String estado;
        int legajoAsociado;
        boolean esAutomatica;
        String justifUso;
        String justifUsoFormateada;
        int nivelArma;
        boolean tieneSello;
        int posicionPolicia;
        int atributoPolicia;
        int atributoArma;
        int posicionArma;
        int tipoArma;
        int comparaArma1;
        int comparaArma2;
        boolean resultValidarLegajoAsociado;
        boolean resultValidarAltaLegajo;
        System.out.println("Bienvenido al Sistema de Gestion de Armas para Policias de Tres de Febrero");
        do {
            menuBase.menu_inicial();
            opcion = sc.nextInt();
            String saltoDeLinea = sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("ALTA POLICIA");
                    System.out.println("Ingrese Nombre: ");
                    nombre = sc.next();
                    nombreFormateado = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
                    System.out.println("Ingrese Apellido: ");
                    apellido = sc.next();
                    apellidoFormateado = apellido.substring(0, 1).toUpperCase() + apellido.substring(1).toLowerCase();
                    System.out.println("Ingrese Legajo: ");
                    legajo = sc.nextInt();
                    resultValidarAltaLegajo = validarAltaLegajo(policias, legajo);
                    if (!resultValidarAltaLegajo) {
                        policias.add(new Policia(nombreFormateado, apellidoFormateado, legajo));
                        System.out.println("Alta Policia OK");
                    } else {
                        System.out.println("No se pudo agregar el policia");
                    }
                    break;
                case 2:
                    if (!policias.isEmpty()) {
                        mostrarPolicias(policias);
                        System.out.println("BAJA POLICIA");
                        System.out.println("Elija la posicion del Policia que desea dar de baja");
                        policias.remove(sc.nextInt());
                        System.out.println("Policia dado de Baja correctamente");
                    } else {
                        System.out.println("No existen policias dados de ALTA");
                    }
                    break;
                case 3:
                    if (!policias.isEmpty()) {
                        mostrarPolicias(policias);
                        System.out.println("MODIFICACION POLICIA");
                        System.out.println("Seleccione la posicion del Policia a modificar");
                        posicionPolicia = sc.nextInt();
                        System.out.println("Seleccione el atributo a modificar");
                        System.out.println("1-Nombre");
                        System.out.println("2-Apellido");
                        System.out.println("3-Legajo");
                        atributoPolicia = sc.nextInt();
                        if (atributoPolicia == 1) {
                            System.out.println("Ingrese nuevo Nombre: ");
                            nombre = sc.next();
                            nombreFormateado = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
                            policias.get(posicionPolicia).setNombre(nombreFormateado);
                            System.out.println("Atributo Policia modificado correctamente");
                        } else if (atributoPolicia == 2) {
                            System.out.println("Ingrese nuevo Apellido: ");
                            apellido = sc.next();
                            apellidoFormateado = apellido.substring(0, 1).toUpperCase() + apellido.substring(1).toLowerCase();
                            policias.get(posicionPolicia).setApellido(apellidoFormateado);
                            System.out.println("Atributo Policia modificado correctamente");
                        } else if (atributoPolicia == 3) {
                            System.out.println("Ingrese nuevo Legajo: ");
                            legajo = sc.nextInt();
                            resultValidarAltaLegajo = validarAltaLegajo(policias, legajo);
                            if (!resultValidarAltaLegajo) {
                                policias.get(posicionPolicia).setLegajo(legajo);
                                System.out.println("Atributo Policia modificado correctamente");
                            } else {
                                System.out.println("No se pudo modificar el policia");
                            }
                        } else
                            System.out.println("Opcion Invalida");
                    } else {
                        System.out.println("No existen policias dados de ALTA");
                    }
                    break;
                case 4:
                    if (!policias.isEmpty()) {
                        mostrarPolicias(policias);
                    } else {
                        System.out.println("No existen policias dados de ALTA");
                    }
                    break;
                case 5:
                    System.out.println("Seleccione tipo de Arma");
                    System.out.println("1-Corta");
                    System.out.println("2-Larga");
                    tipoArma = sc.nextInt();
                    if (tipoArma == 1 || tipoArma == 2) {
                        System.out.println("Ingrese Marca: ");
                        marca = sc.next();
                        marcaFormateada = marca.substring(0, 1).toUpperCase() + marca.substring(1).toLowerCase();
                        System.out.println("Ingrese Cantidad de Municiones: ");
                        cantMuniciones = sc.nextInt();
                        System.out.println("Ingrese Alcance (mts): ");
                        alcance = sc.nextDouble();
                        System.out.println("Ingrese Calibre (mm): ");
                        calibre = sc.nextInt();
                        saltoDeLinea = sc.nextLine();
                        do {
                            System.out.println("Ingrese Estado (NUEVA | EN MANTENIMIENTO | USO): ");
                            estado = sc.nextLine().toUpperCase();
                        } while (!estado.equals("NUEVA") && !estado.equals("EN MANTENIMIENTO") && !estado.equals("USO"));
                        System.out.println("Policia Asociado (legajo): ");
                        legajoAsociado = sc.nextInt();
                        resultValidarLegajoAsociado = validarLegajoAsociado(armascortas, armaslargas, legajoAsociado);
                        if (tipoArma == 1) {
                            System.out.println("Es Automatica (true | false): ");
                            esAutomatica = sc.nextBoolean();
                            if (!resultValidarLegajoAsociado) {
                                armascortas.add(new Corta(marcaFormateada, cantMuniciones, alcance, calibre, estado, esAutomatica, legajoAsociado));
                                System.out.println("Alta OK");
                            } else {
                                System.out.println("No se pudo agregar el arma");
                            }
                        } else {
                            saltoDeLinea = sc.nextLine();
                            System.out.println("Ingrese Justificacion de Uso: ");
                            justifUso = sc.nextLine();
                            justifUsoFormateada = justifUso.substring(0, 1).toUpperCase() + justifUso.substring(1).toLowerCase();
                            do {
                                System.out.println("Ingrese Nivel (1 al 5): ");
                                nivelArma = sc.nextInt();
                            } while (nivelArma < 1 || nivelArma > 5);
                            System.out.println("Tiene Sello (true | false): ");
                            tieneSello = sc.nextBoolean();
                            if (!resultValidarLegajoAsociado) {
                                armaslargas.add(new Larga(marcaFormateada, cantMuniciones, alcance, calibre, estado, justifUsoFormateada, nivelArma, tieneSello, legajoAsociado));
                                System.out.println("Alta OK");
                            } else {
                                System.out.println("No se pudo agregar el arma");
                            }
                        }
                    } else {
                        System.out.println("Opcion Invalida");
                    }
                    break;
                case 6:
                    System.out.println("Seleccione tipo de Arma");
                    System.out.println("1-Corta");
                    System.out.println("2-Larga");
                    tipoArma = sc.nextInt();
                    if (tipoArma == 1) {
                        if (!armascortas.isEmpty()) {
                            mostrarArmasCortas(armascortas);
                            System.out.println("Elija la posicion del Arma que desea dar de baja");
                            armascortas.remove(sc.nextInt());
                            System.out.println("Arma dada de Baja correctamente");
                        } else {
                            System.out.println("No existen armas cortas dadas de ALTA");
                        }
                    } else if (tipoArma == 2) {
                        if (!armaslargas.isEmpty()) {
                            mostrarArmasLargas(armaslargas);
                            System.out.println("Elija la posicion del Arma que desea dar de baja");
                            armaslargas.remove(sc.nextInt());
                            System.out.println("Arma dada de Baja correctamente");
                        } else {
                            System.out.println("No existen armas largas dadas de ALTA");
                        }
                    } else
                        System.out.println("Opcion Invalida");
                    break;
                case 7:
                    System.out.println("Seleccione tipo de Arma");
                    System.out.println("1-Corta");
                    System.out.println("2-Larga");
                    tipoArma = sc.nextInt();
                    if (tipoArma == 1) {
                        if (!armascortas.isEmpty()) {
                            mostrarArmasCortas(armascortas);
                            System.out.println("Seleccione la posicion del Arma a modificar");
                            posicionArma = sc.nextInt();
                            System.out.println("Seleccione el atributo a modificar");
                            System.out.println("1-Marca");
                            System.out.println("2-Cantidad Municiones");
                            System.out.println("3-Alcance");
                            System.out.println("4-Calibre");
                            System.out.println("5-Estado");
                            System.out.println("6-Policia Asociado (legajo)");
                            System.out.println("7-Automatica");
                            atributoArma = sc.nextInt();
                            if (atributoArma == 1) {
                                System.out.println("Ingrese nueva Marca: ");
                                marca = sc.next();
                                marcaFormateada = marca.substring(0, 1).toUpperCase() + marca.substring(1).toLowerCase();
                                armascortas.get(posicionArma).setMarca(marcaFormateada);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 2) {
                                System.out.println("Ingrese nueva Cantidad de Municiones: ");
                                cantMuniciones = sc.nextInt();
                                armascortas.get(posicionArma).setCantMuniciones(cantMuniciones);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 3) {
                                System.out.println("Ingrese nuevo Alcance (mts): ");
                                alcance = sc.nextDouble();
                                armascortas.get(posicionArma).setAlcance(alcance);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 4) {
                                System.out.println("Ingrese nuevo Calibre (mm): ");
                                calibre = sc.nextInt();
                                armascortas.get(posicionArma).setCalibre(calibre);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 5) {
                                saltoDeLinea = sc.nextLine();
                                do {
                                    System.out.println("Ingrese Estado (NUEVA | EN MANTENIMIENTO | USO): ");
                                    estado = sc.nextLine().toUpperCase();
                                } while (!estado.equals("NUEVA") && !estado.equals("EN MANTENIMIENTO") && !estado.equals("USO"));
                                armascortas.get(posicionArma).setEstado(estado);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 6) {
                                System.out.println("Ingrese nuevo Policia asociado (legajo): ");
                                legajoAsociado = sc.nextInt();
                                resultValidarLegajoAsociado = validarLegajoAsociado(armascortas, armaslargas, legajoAsociado);
                                if (!resultValidarLegajoAsociado) {
                                    armascortas.get(posicionArma).setLegajoAsociado(legajoAsociado);
                                    System.out.println("Atributo Arma modificado correctamente");
                                } else {
                                    System.out.println("No se pudo modificar el arma");
                                }
                            } else if (atributoArma == 7) {
                                System.out.println("Ingrese nuevo Automatica (true | false): ");
                                esAutomatica = sc.nextBoolean();
                                armascortas.get(posicionArma).setEsAutomatica(esAutomatica);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else
                                System.out.println("Opcion Invalida");
                        } else {
                            System.out.println("No existen armas cortas dadas de ALTA");
                        }
                    } else if (tipoArma == 2) {
                        if (!armaslargas.isEmpty()) {
                            mostrarArmasLargas(armaslargas);
                            System.out.println("Seleccione la posicion del Arma a modificar");
                            posicionArma = sc.nextInt();
                            System.out.println("Seleccione el atributo a modificar");
                            System.out.println("1-Marca");
                            System.out.println("2-Cantidad Municiones");
                            System.out.println("3-Alcance");
                            System.out.println("4-Calibre");
                            System.out.println("5-Estado");
                            System.out.println("6-Policia Asociado (legajo)");
                            System.out.println("7-Justificacion Uso");
                            System.out.println("8-Nivel Arma");
                            System.out.println("9-Tiene Sello");
                            atributoArma = sc.nextInt();
                            if (atributoArma == 1) {
                                System.out.println("Ingrese nueva Marca: ");
                                marca = sc.next();
                                marcaFormateada = marca.substring(0, 1).toUpperCase() + marca.substring(1).toLowerCase();
                                armaslargas.get(posicionArma).setMarca(marcaFormateada);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 2) {
                                System.out.println("Ingrese nueva Cantidad de Municiones: ");
                                cantMuniciones = sc.nextInt();
                                armaslargas.get(posicionArma).setCantMuniciones(cantMuniciones);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 3) {
                                System.out.println("Ingrese nuevo Alcance (mts): ");
                                alcance = sc.nextDouble();
                                armaslargas.get(posicionArma).setAlcance(alcance);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 4) {
                                System.out.println("Ingrese nuevo Calibre (mm): ");
                                calibre = sc.nextInt();
                                armaslargas.get(posicionArma).setCalibre(calibre);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 5) {
                                saltoDeLinea = sc.nextLine();
                                do {
                                    System.out.println("Ingrese Estado (NUEVA | EN MANTENIMIENTO | USO): ");
                                    estado = sc.nextLine().toUpperCase();
                                } while (!estado.equals("NUEVA") && !estado.equals("EN MANTENIMIENTO") && !estado.equals("USO"));
                                armaslargas.get(posicionArma).setEstado(estado);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 6) {
                                System.out.println("Ingrese nuevo Policia asociado (legajo): ");
                                legajoAsociado = sc.nextInt();
                                resultValidarLegajoAsociado = validarLegajoAsociado(armascortas, armaslargas, legajoAsociado);
                                if (!resultValidarLegajoAsociado) {
                                    armaslargas.get(posicionArma).setLegajoAsociado(legajoAsociado);
                                    System.out.println("Atributo Arma modificado correctamente");
                                } else {
                                    System.out.println("No se pudo modificar el arma");
                                }
                            } else if (atributoArma == 7) {
                                saltoDeLinea = sc.nextLine();
                                System.out.println("Ingrese nueva Justificacion Uso: ");
                                justifUso = sc.nextLine();
                                justifUsoFormateada = justifUso.substring(0, 1).toUpperCase() + justifUso.substring(1).toLowerCase();
                                armaslargas.get(posicionArma).setJustifUso(justifUsoFormateada);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 8) {
                                do {
                                    System.out.println("Ingrese Nivel (1 al 5): ");
                                    nivelArma = sc.nextInt();
                                } while (nivelArma < 1 || nivelArma > 5);
                                armaslargas.get(posicionArma).setNivelArma(nivelArma);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else if (atributoArma == 9) {
                                System.out.println("Ingrese nuevo Tiene Sello (true | false): ");
                                tieneSello = sc.nextBoolean();
                                armaslargas.get(posicionArma).setTieneSello(tieneSello);
                                System.out.println("Atributo Arma modificado correctamente");
                            } else
                                System.out.println("Opcion Invalida");
                        } else {
                            System.out.println("No existen armas largas dadas de ALTA");
                        }
                    } else
                        System.out.println("Opcion Invalida");
                    break;
                case 8:
                    if (!armascortas.isEmpty()) {
                        mostrarArmasCortas(armascortas);
                    } else {
                        System.out.println("No existen armas cortas dadas de ALTA");
                    }
                    if (!armaslargas.isEmpty()) {
                        mostrarArmasLargas(armaslargas);
                    } else {
                        System.out.println("No existen armas largas dadas de ALTA");
                    }
                    break;
                case 9:
                    if (!armascortas.isEmpty()) {
                        validarArmasCortas(armascortas);
                    } else {
                        System.out.println("No existen armas cortas dadas de ALTA");
                    }
                    if (!armaslargas.isEmpty()) {
                        validarArmasLargas(armaslargas);
                    } else {
                        System.out.println("No existen armas largas dadas de ALTA");
                    }
                    break;
                case 10:
                    if (!armaslargas.isEmpty() && armaslargas.size() > 1) {
                        mostrarArmasLargas(armaslargas);
                        System.out.println("Seleccione la posicion del Arma 1 a comparar");
                        comparaArma1 = sc.nextInt();
                        System.out.println("Seleccione la posicion del Arma 2 a comparar");
                        comparaArma2 = sc.nextInt();
                        compararArmasLargas(armaslargas, comparaArma1, comparaArma2);
                    } else {
                        System.out.println("No hay suficientes armas largas para comparar");
                    }
                    break;
                case 11:
                    if (!armascortas.isEmpty()) {
                        filtro200mtsArmasCortas(armascortas);
                    } else {
                        System.out.println("No existen armas cortas dadas de ALTA");
                    }
                    break;
                case 12:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
        } while (opcion != 12);
        sc.close();
    }

    public static void mostrarPolicias(ArrayList<Policia> policias) {
        System.out.println("Lista de Policias");
        System.out.println("------------------------");
        System.out.println("Posicion - Nombre - Apellido - Legajo");
        for (int i = 0; i < policias.size(); i++) {
            System.out.println(i + " " + policias.get(i).getNombre() + " " + policias.get(i).getApellido() + " " + policias.get(i).getLegajo());
        }
    }

    public static void mostrarArmasCortas(ArrayList<Corta> armascortas) {
        System.out.println("Lista de Armas Cortas");
        System.out.println("------------------------");
        System.out.println("Posicion - Marca - CantMuniciones - Alcance (mts) - Calibre (mm) - Estado - Policia Asociado (legajo) - esAutomatica");
        for (int i = 0; i < armascortas.size(); i++) {
            System.out.println(i + " " + armascortas.get(i).getMarca() + " " + armascortas.get(i).getCantMuniciones() + " " + armascortas.get(i).getAlcance() + " " + armascortas.get(i).getCalibre() + " " + armascortas.get(i).getEstado() + " " + armascortas.get(i).getLegajoAsociado() + " " + armascortas.get(i).isEsAutomatica());
        }
    }

    public static void mostrarArmasLargas(ArrayList<Larga> armaslargas) {
        System.out.println("Lista de Armas Largas");
        System.out.println("------------------------");
        System.out.println("Posicion - Marca - CantMuniciones - Alcance (mts) - Calibre (mm) - Estado - Policia Asociado (legajo) - Justificacion Uso - Nivel Arma - TieneSello");
        for (int i = 0; i < armaslargas.size(); i++) {
            System.out.println(i + " " + armaslargas.get(i).getMarca() + " " + armaslargas.get(i).getCantMuniciones() + " " + armaslargas.get(i).getAlcance() + " " + armaslargas.get(i).getCalibre() + " " + armaslargas.get(i).getEstado() + " " + armaslargas.get(i).getLegajoAsociado() + " " + armaslargas.get(i).getJustifUso() + " " + armaslargas.get(i).getNivelArma() + " " + armaslargas.get(i).isTieneSello());
        }
    }

    public static void validarArmasCortas(ArrayList<Corta> armascortas) {
        System.out.println("Armas Cortas en condiciones de ser usadas");
        System.out.println("------------------------");
        System.out.println("Posicion - Marca - CantMuniciones - Alcance (mts) - Calibre (mm) - Estado - Policia Asociado (legajo) - esAutomatica");
        for (int i = 0; i < armascortas.size(); i++) {
            if (armascortas.get(i).getEstado().equals("USO") && armascortas.get(i).getCalibre() >= 9) {
                System.out.println(i + " " + armascortas.get(i).getMarca() + " " + armascortas.get(i).getCantMuniciones() + " " + armascortas.get(i).getAlcance() + " " + armascortas.get(i).getCalibre() + " " + armascortas.get(i).getEstado() + " " + armascortas.get(i).getLegajoAsociado() + " " + armascortas.get(i).isEsAutomatica());
            }
        }
    }

    public static void validarArmasLargas(ArrayList<Larga> armaslargas) {
        System.out.println("Armas Largas en condiciones de ser usadas");
        System.out.println("------------------------");
        System.out.println("Posicion - Marca - CantMuniciones - Alcance (mts) - Calibre (mm) - Estado - Policia Asociado (legajo) - Justificacion Uso - Nivel Arma - TieneSello");
        for (int i = 0; i < armaslargas.size(); i++) {
            if (armaslargas.get(i).getEstado().equals("USO") && armaslargas.get(i).getCalibre() >= 9) {
                System.out.println(i + " " + armaslargas.get(i).getMarca() + " " + armaslargas.get(i).getCantMuniciones() + " " + armaslargas.get(i).getAlcance() + " " + armaslargas.get(i).getCalibre() + " " + armaslargas.get(i).getEstado() + " " + armaslargas.get(i).getLegajoAsociado() + " " + armaslargas.get(i).getJustifUso() + " " + armaslargas.get(i).getNivelArma() + " " + armaslargas.get(i).isTieneSello());
            }
        }
    }

    public static void compararArmasLargas(ArrayList<Larga> armaslargas, int comparaArma1, int comparaArma2) {
        System.out.println("Comparando Armas Largas seleccionadas");
        System.out.println("------------------------");
        if (armaslargas.get(comparaArma1).getNivelArma() > armaslargas.get(comparaArma2).getNivelArma()) {
            System.out.println("El Arma 1, Marca " + armaslargas.get(comparaArma1).getMarca() + " Nivel " + armaslargas.get(comparaArma1).getNivelArma() + " es mayor que el Arma 2, Marca " + armaslargas.get(comparaArma2).getMarca() + " Nivel " + armaslargas.get(comparaArma2).getNivelArma());
        } else {
            System.out.println("El Arma 2, Marca " + armaslargas.get(comparaArma2).getMarca() + " Nivel " + armaslargas.get(comparaArma2).getNivelArma() + " es mayor que el Arma 1, Marca " + armaslargas.get(comparaArma1).getMarca() + " Nivel " + armaslargas.get(comparaArma1).getNivelArma());
        }
    }

    public static void filtro200mtsArmasCortas(ArrayList<Corta> armascortas) {
        System.out.println("Armas Cortas con distancia mayor a 200mts");
        System.out.println("------------------------");
        System.out.println("Posicion - Marca - CantMuniciones - Alcance (mts) - Calibre (mm) - Estado - Policia Asociado (legajo) - esAutomatica");
        for (int i = 0; i < armascortas.size(); i++) {
            if (armascortas.get(i).getAlcance() > 200) {
                System.out.println(i + " " + armascortas.get(i).getMarca() + " " + armascortas.get(i).getCantMuniciones() + " " + armascortas.get(i).getAlcance() + " " + armascortas.get(i).getCalibre() + " " + armascortas.get(i).getEstado() + " " + armascortas.get(i).getLegajoAsociado() + " " + armascortas.get(i).isEsAutomatica());
            }
        }
    }

    public static boolean validarLegajoAsociado(ArrayList<Corta> armascortas, ArrayList<Larga> armaslargas, int legajoAsociado) {
        boolean resultValidarLegajoAsociado = false;
        System.out.println("Validando si existe Policia asociado (legajo)");
        System.out.println("------------------------");
        for (int i = 0; i < armascortas.size() && !resultValidarLegajoAsociado; i++) {
            if (armascortas.get(i).getLegajoAsociado() == legajoAsociado) {
                System.out.println("El Policia (legajo " + legajoAsociado + ") ya posee un arma asignada");
                resultValidarLegajoAsociado = true;
            }
        }
        if (!resultValidarLegajoAsociado) {
            for (int i = 0; i < armaslargas.size() && !resultValidarLegajoAsociado; i++) {
                if (armaslargas.get(i).getLegajoAsociado() == legajoAsociado) {
                    System.out.println("El Policia (legajo " + legajoAsociado + ") ya posee un arma asignada");
                    resultValidarLegajoAsociado = true;
                }
            }
        }
        if (!resultValidarLegajoAsociado) {
            System.out.println("El Policia esta APTO");
        }
        return resultValidarLegajoAsociado;
    }

    public static boolean validarAltaLegajo(ArrayList<Policia> policias, int legajo) {
        boolean resultValidarAltaLegajo = false;
        System.out.println("Validando si existe legajo");
        System.out.println("------------------------");
        for (int i = 0; i < policias.size() && !resultValidarAltaLegajo; i++) {
            if (policias.get(i).getLegajo() == legajo) {
                System.out.println("El legajo " + legajo + " existe");
                resultValidarAltaLegajo = true;
            }
        }
        if (!resultValidarAltaLegajo) {
            System.out.println("El legajo del Policia no existe");
        }
        return resultValidarAltaLegajo;
    }
}