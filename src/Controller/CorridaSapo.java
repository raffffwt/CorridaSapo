package Controller;

import java.util.Random;

public class CorridaSapo extends Thread {
    private volatile Long endTime = null;
    int posicao = 0;
    int dist = 10;

    @Override
    public void run() {
        int sapoId = (int) getId();
        while(this.posicao < this.dist) {
            int pulo = pular();
            System.out.println("Sapo " + sapoId + " pulou " + pulo + " metros! Percorreu " + this.posicao + " metros! ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis();
    }

    public Long getEndTime() {
        return this.endTime;
    }
    
    public int pular() {
        Random rnd = new Random();
        int pular = rnd.nextInt(4);
        this.posicao += pular;
        return pular;
    }

}