package com.fabio.thread.dati;

import java.util.Stack;

public class DataShared {
	
	private Stack<Nodo> nastroComune;
	private Integer limiteSuperiore;
	private Integer limiteInferiore;
	private Integer capacita;
	private static DataShared dShared;
	private static int numeroPop=0;
	private static int numeroPush=0;
	private Integer id;
	
	private DataShared() {
		if(nastroComune==null) {
			nastroComune=new Stack<Nodo>();
			this.capacita=nastroComune.size();
		}
	}
	
	public static DataShared getInstance(){
		if(dShared==null) {
			dShared=new DataShared();
		}
		return dShared;
	}

	public Stack<Nodo> getNastroComune() {
		return nastroComune;
	}
	
	
	public synchronized void  push(Nodo nodo,String nomeThread) throws Exception{
		if(nodo!=null && dShared!=null && validaInserimento()) {
			dShared.getNastroComune().add(nodo);
			numeroPush++;
			System.out.println("Nodo "+nodo.toString()+" "+"aggiunto allo shared dal thread"+nomeThread+". Capacità corrente:"+dShared.getCapacita());
		}else {
			wait();
			System.out.println(nomeThread+" "+"in attesa...");
		}
		System.out.println("Rilascio lock in corso...");
		notifyAll();
		System.out.println("Lock sul DataShared rilasciato");

	}
	
	public synchronized void pop(String nomeThread) throws Exception{
		if(validaRimozione()) {
			Nodo nodo=dShared.getNastroComune().pop();
			numeroPop++;
			System.out.println("Nodo "+nodo.toString()+" "+"rimosso dallo shared dal thread"+nomeThread+". Capacità corrente:"+dShared.getCapacita());
		}else {
			wait();
			System.out.println(nomeThread+" "+"in attesa...");
		}
		System.out.println("Rilascio lock in corso...");
		notifyAll();
		System.out.println("Lock sul DataShared rilasciato");
	}


	public void setNastroComune(Stack<Nodo> nastroComune) {
		this.nastroComune = nastroComune;
	}


	
	public Integer getCapacita() {
		if(nastroComune!=null) {
			this.capacita=nastroComune.size();
		}
		return capacita;
	}

	public void setCapacita(Integer capacita) {
		this.capacita = capacita;
	}

	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLimiteSuperiore() {
		return limiteSuperiore;
	}

	public void setLimiteSuperiore(Integer limiteSuperiore) {
		this.limiteSuperiore = limiteSuperiore;
	}

	public Integer getLimiteInferiore() {
		return limiteInferiore;
	}

	public void setLimiteInferiore(Integer limiteInferiore) {
		this.limiteInferiore = limiteInferiore;
	}

	public static DataShared getdShared() {
		return dShared;
	}

	public static void setdShared(DataShared dShared) {
		DataShared.dShared = dShared;
	}
	
	public boolean validaInserimento() {
		if(capacita==null || (capacita>=this.limiteSuperiore)) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean validaRimozione() {
		if(capacita==null || (capacita!=null && capacita.equals(0) || capacita.compareTo(limiteInferiore)<0)) {
			return false;
		}else {
			
			return true;
		}
	}

	public static int getNumeroPop() {
		return numeroPop;
	}

	public static void setNumeroPop(int numeroPop) {
		DataShared.numeroPop = numeroPop;
	}

	public static int getNumeroPush() {
		return numeroPush;
	}

	public static void setNumeroPush(int numeroPush) {
		DataShared.numeroPush = numeroPush;
	}
	
	
	
}
