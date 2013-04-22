/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Customer {

  private int arrivalTime;
  private int transactionTime;
  private int customerNumber;
  private int numberOfStations;
  private int startStation;

  //constructor for customer in line to board train
  public Customer (int clock,int tTime,int cNumber, int nStations, int sStation) {
        arrivalTime = clock;
        transactionTime = tTime;
        customerNumber = cNumber;
        numberOfStations = nStations;
        startStation = sStation;
  }

  //mutators
  public int getArrivalTime() { return arrivalTime; }
  public int getTransactionTime() { return transactionTime; }
  public int getCustomerNumber() { return customerNumber; }
  public int getNumberOfStations() { return numberOfStations; }
  public int getStartStation() { return startStation; }
}