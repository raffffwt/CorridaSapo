package View;

import java.util.*;

import Controller.CorridaSapo;

public class Main {

    public static void main(String[] args) {
        int sapos = 5;
        CorridaSapo[] corridaArray = new CorridaSapo[sapos];
        List<Long> finishedThreads = new ArrayList<Long>();

        System.out.println("Comecando corrida");
        for(int i = 0; i < corridaArray.length; i++) {
            corridaArray[i] = new CorridaSapo();
        }

        for (CorridaSapo corridaSapo : corridaArray) {
            corridaSapo.start();
        }
        
        while (finishedThreads.size() != corridaArray.length) {
            for(int i = 0; i < corridaArray.length; i++) {
                CorridaSapo corridaSapo = corridaArray[i];
                Long endTime = corridaSapo.getEndTime();
                if(endTime == null || finishedThreads.stream().anyMatch(sapoThreadId -> sapoThreadId.equals(corridaSapo.getId())))
                    continue;
                finishedThreads.add(corridaSapo.getId());

                System.out.println(String.format("O sapo %d terminou na %dº posição", corridaSapo.getId(), finishedThreads.size()) + "\n");
            }
            
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}