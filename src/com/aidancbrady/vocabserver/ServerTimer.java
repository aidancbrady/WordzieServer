package com.aidancbrady.vocabserver;

import com.aidancbrady.vocabserver.file.AccountHandler;

public final class ServerTimer extends Thread
{
	public ServerTimer()
	{
		setDaemon(true);
	}
	
	@Override
	public void run()
	{
		while(VocabServer.instance().serverRunning)
		{
			try {
				Thread.sleep(1000*60*15);
				
				AccountHandler.save();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
