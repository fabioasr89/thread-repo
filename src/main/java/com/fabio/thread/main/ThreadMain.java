package com.fabio.thread.main;

import com.fabio.thread.dati.DataShared;
import com.fabio.thread.dati.Nodo;
import com.fabio.thread.thread.AggiungiDatoThread;
import com.fabio.thread.thread.EliminaDatoThread;

public class ThreadMain {
	
	private static Integer limiteInferiore=50;
	private static Integer limiteSuperiore=100;
	private static Integer id=1;
	public static void main(String[] args) {
		int i=0;
		AggiungiDatoThread aggiungiThread=null;
		EliminaDatoThread eliminaDatoThread=null;
		DataShared dataShared=DataShared.getInstance();
		//capacità iniziale
		dataShared.setCapacita(0);
		dataShared.setLimiteInferiore(limiteInferiore);
		dataShared.setLimiteSuperiore(limiteSuperiore);
		Nodo nodo=null;
		while(i<10000) {
			nodo=new Nodo();
			nodo.setId(String.valueOf(id++));
			nodo.setContent("");
			aggiungiThread=new AggiungiDatoThread(dataShared,nodo,i);
			aggiungiThread.setNodo(nodo);
			
			eliminaDatoThread=new EliminaDatoThread(dataShared,i);
			
			i++;
		}
			synchronized (dataShared) {
				if(i>=1000) {
					System.out.println("Processi conclusi. Dimensione finale dello shared:"+dataShared.getCapacita());
					System.out.println("Numero pop:"+dataShared.getNumeroPop());
					System.out.println("Numero push:"+dataShared.getNumeroPush());
				}
			}
		
	}

}
