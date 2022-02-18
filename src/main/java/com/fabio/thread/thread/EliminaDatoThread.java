package com.fabio.thread.thread;

import com.fabio.thread.dati.DataShared;
import com.fabio.thread.dati.Nodo;

public class EliminaDatoThread implements Runnable{
	
	private DataShared dataShared;
	private String nome;
	private Integer numeroThread;
	private Thread thread;
	public EliminaDatoThread(DataShared dataShared,int i) {
		this.dataShared=dataShared;
		this.numeroThread=i;
		this.nome="Thread-Elimina:"+numeroThread;
		thread=new Thread(this);
		this.thread.setName(nome);
		thread.start();
	}

	

	public synchronized void run() {
		try {
			dataShared.pop(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
