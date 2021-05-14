package org.fkjava.web;

import javax.websocket.*;
import java.util.*;
import javax.websocket.server.*;

/**
 * Description:<br>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2020, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 5.0
 */
// @ServerEndpointע�����ε��ཫ��ΪWebSocket�ķ����
@ServerEndpoint(value="/chatSocket")
public class ChatEndpoint
{
	static List<Session> clients = Collections
		.synchronizedList(new ArrayList<Session>());
	@OnOpen // ��ע�����εķ�������ͻ�������ʱ������
	public void start(Session session)
	{
		// ÿ���пͻ����ӽ���ʱ���ռ��ÿͻ���Ӧ��session
		clients.add(session);
	}
	@OnMessage // ��ע�����εķ�������ͻ�����Ϣ����ʱ������
	public void message(String message, Session session) throws Exception
	{
		// �յ���Ϣ�󣬽���Ϣ�����пͻ�����һ��
		for (var s : clients)
		{
			RemoteEndpoint.Basic remote = s.getBasicRemote();
			remote.sendText(message);
		}
	}
	@OnClose // ��ע�����εķ�������ͻ������ӹر�ʱ������
	public void end(Session session, CloseReason closeReason)
	{
		// ÿ���пͻ����ӹر�ʱ��ɾ���ÿͻ���Ӧ��session
		clients.remove(session);
	}
	@OnError // ��ע�����εķ�������ͻ��˳���ʱ������
	public void error(Session session, Throwable throwable)
	{
		// ÿ���пͻ����ӳ���ʱ��ɾ���ÿͻ���Ӧ��session
		clients.remove(session);
	}
}

