package Message;

import com.google.gson.Gson;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SocketWrrapper implements Runnable {

	
	private Socket socket = null;
	public SocketWrrapper(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try{
			String connIp = socket.getInetAddress().getHostAddress();
			System.out.println(connIp + "���� ���� �õ�.");

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			
			Gson gson = new Gson();
			JSONObject jo = gson.fromJson(br.readLine(), JSONObject.class);
			List<Map<Object, Object>> list = (ArrayList<Map<Object, Object>>) jo.get("list");
			
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
			// Ŭ���̾�Ʈ�� ���ڿ� ����
			pw.println("���ſϷ�~~");
			pw.flush();
			
		}catch(IOException e){
			
		}finally{
			try{
				if(pw != null) { pw.close();}
				if(br != null) { br.close();}
				if(socket != null){socket.close();}
			}catch(IOException e){
				
			}
		}
	}
	public void sendData(byte[] bytes, Socket socket){
        try {
            OutputStream os = socket.getOutputStream();
            os.write(bytes);
            os.flush();
        } catch(Exception e1){
            e1.printStackTrace();
        }
    }
	public void receive(Socket socket) throws IOException {
        int maxBufferSize = 1024;
        byte[] recvBuffer = new byte[maxBufferSize];
        InputStream is = socket.getInputStream();
        int nReadSize = is.read(recvBuffer);
        System.out.println("Ŭ���̾�Ʈ�� ���� ������ ����");
        if (nReadSize > 0) {
            MessageVO receiveMsg = toObject(recvBuffer, MessageVO.class);
            System.out.println(receiveMsg.getTitle());
            System.out.println(receiveMsg.getWriter());
            System.out.println(receiveMsg.getContent());
            System.out.println(receiveMsg.getIdx());
           
        }
    }
	public <T> T toObject (byte[] bytes, Class<T> type)
    {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream (bis);
            obj = ois.readObject();
        }
        catch (IOException ex) {
            //TODO: Handle the exception
        }
        catch (ClassNotFoundException ex) {
            //TODO: Handle the exception
        }
        return type.cast(obj);
    }
}

