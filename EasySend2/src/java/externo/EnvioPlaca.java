package externo;

public class EnvioPlaca {

    public static void enviarMensagem(String telefone, String mensagem) {

        System.out.println(telefone + " /n " + mensagem);

        try {


            Conn n = new Conn();
            String msg2 = "action: login\r\n"
                    + "username: mark\r\n"
                    + "secret: mysecret\r\n"
                    + "events: on\r\n\r\n";
            n.mandaComando(msg2);

            msg2 = "action: command\r\n" + "command: Khomp sms b0 " + telefone + " " + mensagem + "\r\n\r\n";
            Thread.sleep(2500);
            
            System.out.println(msg2);
            
           // msg2 = "action: logoff\r\n";

            System.out.println(msg2);

            n.mandaComando(msg2);
            //String msgBanco="";

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Game Over");
    }
}
