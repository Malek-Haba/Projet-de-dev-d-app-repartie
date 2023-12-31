package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Cette classe correspond a un Compte distant. Elle permet aux clients
 * d'effectuer un depot , un retrait, ou consulter leur solde.
 * Elle implemente l'interface Compte.
 */

public class CompteDistant extends UnicastRemoteObject implements Compte{

	
	private static final long serialVersionUID = 1L;
	private double solde ;
	
	protected CompteDistant() throws RemoteException {
		// TODO Auto-generated constructor stub
		//super();
		solde=0;
		
	}

	@Override
	public synchronized boolean retrait(double montant) throws RemoteException {
		// TODO Auto-generated method stub
		if ((solde - montant)>=0)
		{
			solde -= montant;
			return true;
		}
		else return false;
	}

	@Override
	public  synchronized boolean depot(double montant) throws RemoteException {
		// TODO Auto-generated method stub
		try{
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			solde += montant;
			return true;
		}catch(Exception e)
		{
			return false;	
		}
	}

	@Override
	public double getSolde() throws RemoteException {
		// TODO Auto-generated method stub
		return solde;
	}

}
