package tr.org.postman.server;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class EchoHandler extends IoHandlerAdapter {
	
	@Override
	    public void messageReceived( IoSession session, Object message ) throws Exception
	    {
	        String str = message.toString();
	        if( str.trim().equalsIgnoreCase("quit") ) {
	            session.close();
	            return;
	        }

	        Date date = new Date();
	        session.write( date.toString() );
	        System.out.println("Message written...");
	    }
	
	

}
