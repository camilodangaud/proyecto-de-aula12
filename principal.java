import java.util.Scanner;
public class principal {
    static Scanner entrada = new Scanner(System.in);
    static usuario[] usuarios = new usuario[5];
    static usuario suario = new usuario();
    static electrodomestico[] electrodomesticos = new electrodomestico[50];
    static electrodomestico lectrodomestico = new electrodomestico();
    static gastoele[] gastos = new gastoele[5000];
    static gastoele gast = new gastoele();
    static String nom,codigo,entrar,nom_ele,salir,nom_gas;
    static int no,na = 0, ne1 = 0,ni = 0,ne=0,posicion_gasto,posicion_usuario,opcion,posicion_electrodomestico;
    static double k = 0;
    public static void main(String[] args) {     
        suario = new usuario();
        suario.nombre = "camilo";
        suario.apellido = "dangaud";
        suario.nrodocumento = "123";
        suario.nrocelular = "1234";
        suario.email = "camilo@gmail.com";
        usuarios[na] = suario;
        na++;
        suario = new usuario();
        suario.nombre = "melany";
        suario.apellido = "olivera";
        suario.nrodocumento = "1234";
        suario.nrocelular = "1234";
        suario.email = "melany@gmail.com";
        usuarios[na] = suario;
        na++;
        lectrodomestico = new electrodomestico();
        lectrodomestico.nombre = "nevera";
        lectrodomestico.nroserie = "123";
        lectrodomestico.marca = "lgplus";
        lectrodomestico.posicion_usu = 0;
        electrodomesticos[ne1]=lectrodomestico;
        ne1++;
        lectrodomestico = new electrodomestico();
        lectrodomestico.nombre = "lavadora";
        lectrodomestico.nroserie = "1234";
        lectrodomestico.marca = "masterx";
        lectrodomestico.posicion_usu = 1;
        electrodomesticos[ne1]=lectrodomestico;
        ne1++;
        gast = new gastoele();
        gast.dia = "12/01/2022";
        gast.gasto = 123;
        gast.posicion_ele = 0;
        gastos[ni] = gast;
        ni++;
        do{
            limpiar();
            menu_Crud();
            System.out.println("");
            switch (codigo){
                case "usuarios":
                gestionar_usuario();
                break;
                case "equipos":
                gestionar_electrodomestico();
                break;
                case "gastos":
                gestionar_gasto();
                break;
                default:
                System.out.println("\n¡Gracias por usar nuestro programa!\n");
            }
        }while(codigo.equals("usuarios")||codigo.equals("equipos")|| codigo.equals("gastos"));
    }
    public static void gestionar_usuario(){
        do{
            nemudeusuario();
            System.out.println("Digite la opción: ");
            opcion = entrada.nextInt();
            System.out.println("");
            switch(opcion){
                case 1:
                if (na < 5){
                    System.out.println("Digite número de documento del usuario: ");
                    nom = entrada.next();
                    posicion_usuario = consultarUsuario(nom);
                    if(posicion_usuario == -1){
                        suario = new usuario();
                        System.out.println("Digite el nombre: ");
                        suario.nombre = entrada.next();
                        System.out.println("Digite el apellido: ");
                        suario.apellido = entrada.next();
                        System.out.println("Digite el número de celular: ");
                        suario.nrocelular = entrada.next();
                        System.out.println("Digite el email: ");
                        suario.email = entrada.next();
                        suario.nrodocumento = nom;
                        usuarios[na]=suario;
                        na++;
                        System.out.println("\n¡El usuario "+suario.nrodocumento+ " se registró correctamente!\n");
                        pausa();
                    }else {
                        System.out.println("Nombre ya registrado");
                        mostrarusuario(posicion_usuario);
                        pausa();
                    }
                }else {
                    System.out.println("Cantidad de registros de usuarios ha alcanzado su máximo. ");
                    pausa();
                }
                break;
                case 2:
                    System.out.println("Digite 'consultar' para consultar un documento. Digite 'listar' para ver todos los documentos: ");
                    entrar = entrada.next();
                    switch(entrar){
                        case "consultar":
                        System.out.println("Digite número de documento del usuario");
                        nom = entrada.next();
                        posicion_usuario = consultarUsuario(nom);
                        if(posicion_usuario == -1){
                            System.out.println("El usuario no existe.");
                            pausa();
                        }else{
                            mostrarusuario(posicion_usuario);
                            pausa();
                        }
                        break;
                        case "listar":
                        for(int i = 0;i<5;i++){
                            if (usuarios[i] == null){
                                
                            }else{
                                mostrarusuario(i);
                            }
                        }
                        pausa();
                        break;
                    }
                break;           
                case 3:
                    System.out.println("Digite número de documento del usuario: ");
                    nom = entrada.next();
                    posicion_usuario = consultarUsuario(nom);
                    if(posicion_usuario == -1){
                        System.out.println("Usuario inexistente, digite uno existente");
                        pausa();
                    }else{
                        System.out.println("Digite el nombre: ");
                        suario.nombre = entrada.next();
                        System.out.println("Digite el apellido: ");
                        suario.apellido = entrada.next();
                        System.out.println("Digite el número de celular: ");
                        suario.nrocelular = entrada.next();
                        System.out.println("Digite el email: ");
                        suario.email = entrada.next();
                        suario.nrodocumento = nom;
                        
                        System.out.println("¡Usuario modificado con exito!");
                        pausa();
                    }
                break;
                case 4:
                System.out.println("Digite número de documento del usuario");
                    nom = entrada.next();
                    posicion_usuario = consultarUsuario(nom);
                    if(posicion_usuario == -1){
                        System.out.println("Usuario inexistente, digite uno existente");
                        pausa();
                    }else{
                        mostrarusuario(posicion_usuario);
                        System.out.println("¿Desea borrar este usuario? 1.'si' 2.'no'");
                        System.out.println("presione 1 o 2");
                        no = entrada.nextInt();
                        if(no == 1){
                            for (int i = posicion_usuario; i < na-1; i++) {
                                usuarios[i] = usuarios[i+1];
                            }
                        na--;
                        System.out.println("¡El usuario ha sido eliminado con éxito!");
                        pausa();
                    }else{
                        System.out.println("Usted no ha borrado el usuario");
                        pausa();
                    }
                    }
                break;
                case 5:
                System.out.println("Usted ha salido al menu principal");
                pausa();
                break;
                default:
                System.out.println("Opción inválida");
                }
        }while(opcion != 5);
    }
    public static void menu_Crud(){
    System.out.println("Para ingresar al menú de usuarios digite la palabra: (usuarios)");
    System.out.println("Para ingresar al menú de equipos del usuario digite: (equipos)");
    System.out.println("para ingresar al menu de gestion de gastos de energia digite: (gastos)");
    System.out.println("salir del programa digite:(salir)");
    codigo = entrada.next();
    }
    public static void mostrarusuario(int posicion_est){
    System.out.println("==========================");
    System.out.println("        usuario           ");
    System.out.println("==========================");
    System.out.println("Nombre: "+ usuarios[posicion_est].nombre);
    System.out.println("Apellido: "+ usuarios[posicion_est].apellido);
    System.out.println("Número de documento: "+ usuarios[posicion_est].nrodocumento);
    System.out.println("Email: "+ usuarios[posicion_est].email);
    System.out.println("Número de celular: "+ usuarios[posicion_est].nrocelular);
    System.out.println("");
    }
    public static int consultarUsuario(String nom){
    int posicion = -1;
    for(int j = 0;j<na;j++){
        if(usuarios[j].nrodocumento.equals(nom)){
            posicion = j;
        }
    }
    return posicion;
    }
    public static void nemudeusuario(){
    System.out.println("1. Registrar usuario");
    System.out.println("2. Consultar usuario");
    System.out.println("3. Modificar usuario");
    System.out.println("4. Eliminar usuario");
    System.out.println("5. Salir");
    }
    public static void gestionar_electrodomestico(){
    do{
        System.out.println("Digite el número de documento del usuario del que desea registrar los electrodomesticos");
        nom = entrada.next();
        posicion_usuario = consultarUsuario(nom);
        System.out.println("");
        if(posicion_usuario == -1){
            System.out.println("Usuario inexistente, digite otro");
            pausa();
        }else{
            do{
                menuelectrodomestico();
                opcion = entrada.nextInt();
                System.out.println("");
                switch(opcion){
                case 1:
                if (ne1 < 50) {
                    System.out.println("Digite el número de serie");
                    nom_ele = entrada.next();
                    posicion_electrodomestico = consultarElectrodomestico(nom_ele);
                    if (posicion_electrodomestico == -1) {
                        lectrodomestico = new electrodomestico();
                        System.out.println("Digite el tipo de electrodoméstico Ej(lavadora),(nevera),(etc): ");
                        lectrodomestico.nombre = entrada.next();
                        System.out.println("Digite la marca Ej(lavadoramasteforx3000),(neveralgplus64),(etc): ");
                        lectrodomestico.marca = entrada.next();
                        lectrodomestico.nroserie =  nom_ele;
                        lectrodomestico.posicion_usu = posicion_usuario;
                        electrodomesticos[ne1]= lectrodomestico;
                        ne1++;
                        System.out.println("¡Electrodoméstico registrado con éxito!");
                        pausa();
                    }else {
                        System.out.println("Electrodoméstico ya registrado");
                        mostrarelectrodomestico(posicion_electrodomestico);
                        pausa();
                    }
                }else{
                    System.out.println("Cantidad de registros de electrodomésticos ha alcanzado su máximo");
                    pausa();
                }
                break;
                case 2:
                System.out.println("Digite 'consultar' para consultar un electrodoméstico. Digite 'listar' para ver todos los electrodomésticos");
                entrar = entrada.next();
                System.out.println("");
                switch(entrar){
                    case "consultar":    
                    System.out.println("Digite el número de serie: ");
                    nom_ele =entrada.next();
                    posicion_electrodomestico = consultarElectrodomestico(nom_ele);
                    if (posicion_electrodomestico == -1) {
                        System.out.println("El electrodoméstico no existe");
                        pausa();
                    }else{
                        mostrarelectrodomestico(posicion_electrodomestico);
                        pausa();
                    }
                    break;
                    case "listar":
                    for(int j = 0;j<50;j++){
                        if(electrodomesticos[j] == null){
                        
                        }else if(electrodomesticos[j].posicion_usu == posicion_usuario){
                            mostrarelectrodomestico(j);
                            System.out.println("");
                        }
                    }
                    pausa();
                    break;
                    }   
                break;
                case 3:
                System.out.println("Digite el número de serie: ");
                nom_ele =entrada.next();
                posicion_electrodomestico = consultarElectrodomestico(nom_ele);
                    if (posicion_electrodomestico == -1) { 
                        System.out.println("Electrodoméstico inexistente");
                        pausa(); 
                    }else {
                        System.out.println("Digite el tipo de electrodoméstico Ej(lavadora),(nevera),(etc): ");
                        lectrodomestico.nombre = entrada.next();
                        System.out.println("Digite la marca Ej(lavadoramasteforx3000),(neveralgplus64),(etc): ");
                        lectrodomestico.marca = entrada.next();
                        lectrodomestico.nroserie =  nom_ele;
                        electrodomesticos[ne1]= lectrodomestico;
                        System.out.println("electrodoméstico modificado");
                        pausa();
                    }
                break;
                case 4:
                System.out.println("Digite la serie del electrodoméstico");
                nom_ele = entrada.next();
                posicion_electrodomestico = consultarUsuario(nom_ele);
                if(posicion_electrodomestico == -1){
                    System.out.println("electrodoméstico inexistente, digite uno existente");
                    pausa();
                }else{
                    mostrarelectrodomestico(posicion_electrodomestico);
                    System.out.println("¿Desea borrar este electrodoméstico? 1.'si' 2.'no'");
                    no = entrada.nextInt();
                    if(no == 1){
                        for (int i = posicion_electrodomestico; i < ne1-1; i++) {
                            electrodomesticos[i] = electrodomesticos[i+1];
                        }
                    ne1--;
                    System.out.println("¡El electrodoméstico ha sido eliminado con éxito!");
                    pausa();
                    }else{
                        System.out.println("Usted no ha borrado el electrodomestico");
                        pausa();
                    }
                break;
                }
            }
            }while(opcion != 5);
        }
        System.out.println("¿Desea salir al menú principal? 'si' 'no'");
        salir = entrada.next();
        pausa();
        }while (salir.equals("no"));
    }
    public static void menuelectrodomestico(){
    System.out.println("Digite la opción: ");
    System.out.println("1. Registrar electrodoméstico.");
    System.out.println("2. Consultar electrodoméstico.");
    System.out.println("3. Modificar electrodoméstico.");
    System.out.println("4. Eliminar electrodoméstic.");
    System.out.println("5. Salir");
    }
    public static int consultarElectrodomestico (String nom_ele) {
        int posicion = -1;
        for (int i = 0; i<ne1; i++) {
            if (electrodomesticos[i].nroserie.equals(nom_ele)) {
                posicion = i;
            }
        }
        return posicion;
    }
    public static void mostrarelectrodomestico( int posicion_estetica){
        System.out.println("==========================");
        System.out.println("Usuario: "+usuarios[posicion_usuario].nrodocumento);
        System.out.println("==========================");
        System.out.println("Nombre: " + electrodomesticos[posicion_estetica].nombre);
        System.out.println("Nro.serie: "+ electrodomesticos[posicion_estetica].nroserie);
        System.out.println("Marca: "+ electrodomesticos[posicion_estetica].marca);
        
    }
    public static void gestionar_gasto(){
        do{
        System.out.println("Digite el número de documento del usuario que desea gestionar el gasto de sus electrodomésticos");
        nom = entrada.next();
        posicion_usuario = consultarUsuario(nom);
        System.out.println("");
        if (posicion_usuario == -1){
            System.out.println("Usuario inexistente, digite otro");
            System.out.println("");
        }else{
            System.out.println("Ingrese el electrodoméstico");
            System.out.println("Digite el número de serie");
            nom_ele = entrada.next();
            posicion_electrodomestico = consultarElectrodomestico(nom_ele);
            if (electrodomesticos[posicion_electrodomestico].posicion_usu == posicion_usuario){
                if (posicion_electrodomestico == -1){
                    System.out.println("Electrodoméstico inexistente");
                    System.out.println("");
                }else{
                    do{
                    menu_gasto();
                    opcion = entrada.nextInt();
                        switch (opcion){
                            case 1:
                            System.out.println("Digite el día, mes y año dd_mm_aa");
                            nom_gas = entrada.next();
                            posicion_gasto = consultargasto(nom_gas);
                            if(ni<5000){
                                if (posicion_gasto == -1){
                                    gast = new gastoele();
                                    gast.dia = nom_gas;
                                    System.out.println("Digite el gasto del electrodoméstico en esa fecha");
                                    gast.gasto = entrada.nextDouble();
                                    gast.posicion_ele = posicion_electrodomestico;
                                    gastos[ni] = gast;
                                    ni++;
                                    ne++;
                                    System.out.println("¡Gasto registrado!");
                                    pausa();
                                }else {
                                    System.out.println("Ese día ya contiene un gasto asignado");
                                    mostrargasto(posicion_gasto);
                                    pausa();
                                }
                            }else {
                                System.out.println("Ya no se puede ingresar mas dias");
                                pausa();
                            }
                            break;
                            case 2:
                            System.out.println("==========================");
                            System.out.println("usuario: "+usuarios[posicion_usuario].nrodocumento);
                            System.out.println("electrodoméstico: "+ electrodomesticos[posicion_electrodomestico].nroserie);
                            System.out.println("==========================");
                            for(int q = 0;q<=ne;q++){
                                if (gastos[q].posicion_ele == posicion_electrodomestico){
                                    if(gastos[q] == null){
                                        
                                    }else {
                                        mostrargasto(q);
                                        k = gastos[q].gasto + k;
                                    }
                                }else {

                                }
                            }
                            System.out.println("");
                            System.out.println("Esos son todos los días registrados para el electrodoméstico "+ electrodomesticos[posicion_electrodomestico].marca);
                            System.out.println("En total se ha acumulado "+k+"kw");
                            pausa();
                            break;
                            case 3:
                            System.out.println("Digite el dia, mes y año dd/mm/aa");
                            nom_gas = entrada.next();
                            posicion_gasto = consultargasto(nom_gas);
                            if (posicion_gasto == -1 ){
                                System.out.println("Ese día no está registrado");
                                pausa();
                            }else{
                                gast.dia = nom_gas;
                                System.out.println("Digite el gasto del electrodoméstico en esa fecha");
                                gast.gasto = entrada.nextDouble();
                                gast.posicion_ele = posicion_electrodomestico;
                                gastos[ni] = gast;
                                System.out.println("¡Gasto registrado!");
                                pausa();
                            }
                            break;
                            case 4:
                            System.out.println("Digite el día, mes y año dd/mm/aa");
                            nom_gas = entrada.next();
                            posicion_gasto = consultargasto(nom_gas);
                            if(posicion_gasto == -1){
                                System.out.println("Gasto inexistente, digite uno existente");
                                pausa();
                            }else{
                                mostrarelectrodomestico(posicion_gasto);
                                System.out.println("¿Desea borrar este gasto? 1.'si' 2.'no'");
                                no = entrada.nextInt();
                                if(no == 1){
                                    for (int i = posicion_gasto; i < ni-1; i++) {
                                        gastos[i] = gastos[i+1];
                                    }
                                ni--;
                                System.out.println("¡El gasto ha sido eliminado con éxito!");
                                pausa();
                            }else{
                                System.out.println("Usted no ha borrado el gasto");
                                pausa();
                            
                            }
                            }
                            break;
                            case 5:
                            System.out.println("Usted ha salido del menú");
                            break;
                            default:
                            System.out.println("Opción inválida");
                        }
                    }while(opcion != 5);
                
                }
            }else if (electrodomesticos[posicion_electrodomestico].posicion_usu != posicion_usuario){
                System.out.println("El electrodomestico no le pertenece al usuario digitado");
                System.out.println("");
            }
            System.out.println("¿Desea salir al menú principal? 'si' 'no'");
            salir = entrada.next();
            pausa();
            }
            }while (salir.equals("no"));
    }
    public static void menu_gasto(){
        System.out.println("1. Registrar gasto");
        System.out.println("2. Consultar gasto");
        System.out.println("3. Modificar gasto");
        System.out.println("4. Eliminar gasto");
        System.out.println("5. Salir");
    }
    public static int consultargasto(String nom_gas){
    int posicion = -1;
    for (int i = 0;i<=ne;i++){
        if (gastos[i].dia.equals(nom_gas)){
            posicion = i;
        }
    }
    return posicion;
    }
    public static void mostrargasto(int pos_est1){
    System.out.println("Para el "+gastos[pos_est1].dia+" se gastó: "+gastos[pos_est1].gasto+"kw");
    }
    public static void pausa(){
    entrada.nextLine();
    System.out.println("presione enter para continuar.......");
    entrada.nextLine();
    }
    public static void limpiar(){
    try{
        ProcessBuilder pd = new ProcessBuilder("cmd","/c","cls");
        Process startProcess = pd.inheritIO().start();
        startProcess.waitFor();
    }catch(Exception e){
        System.out.println(e);
    }
    }
    }