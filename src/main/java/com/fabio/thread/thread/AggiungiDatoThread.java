package com.fabio.thread.thread;

import java.util.List;

import com.fabio.thread.dati.DataShared;
import com.fabio.thread.dati.Nodo;
/**Thread che manipola i dati di una lista condivisa con un altri thread paralleli*/
public class AggiungiDatoThread implements Runnable{

	private String nome;
	private DataShared dataShared;
	private static int numeroPush=0;
	private Nodo nodo;
	private Thread thread;

	private Integer numeroThread;
	
	public AggiungiDatoThread(DataShared dataShared,Nodo nodo,Integer num) {
		this.dataShared=dataShared;
		this.nodo=nodo;
		this.numeroThread=num;
		this.nome="Thread-Aggiungi "+num;
		thread=new Thread(this);
		thread.setName(nome);
		thread.start();
	}
	

	
	
	public void run(){
		System.out.println("Thread "+nome+" "+"in esecuzione...");
		try {
				dataShared.push(nodo,nome);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}


	public DataShared getDataShared() {
		return dataShared;
	}

	public void setDataShared(DataShared dataShared) {
		this.dataShared = dataShared;
	}

	public Nodo getNodo() {
		return nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}
	
	
}
