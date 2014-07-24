package com.hackbulgaria.corejava;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class PrintIP {

        public static void main(String args[]) throws SocketException {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            InetAddress inetAddress = null;
//            try {
//                InetAddress myAddress = InetAddress.getByName("/192.168.1.22");
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
            
            for (NetworkInterface netint : Collections.list(nets))
                if (!netint.isVirtual() && !netint.isLoopback() && netint.isUp()) {                   
                inetAddress = getIPAddress(netint);
                }            
            System.out.printf("InetAddress: %s\n", inetAddress);
           // List<InetAddress> neighbours = getNeighbours(inetAddress);
            
        }

        public static InetAddress getIPAddress(NetworkInterface netint) throws SocketException {
            Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
            for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                if (inetAddress instanceof Inet4Address) {
                    System.out.printf("InetAddress: %s\n", inetAddress);
                    return inetAddress;
                }
            }
            return null;
        }
        
//        public static List<InetAddress> getNeighbours (InetAddress inetAddress) {
//            List<InetAddress> list = new ArrayList<>();
//            String address = inetAddress.toString().substring(0, inetAddress.toString().lastIndexOf("."));
//            InetAddress currentAddress = null;
//            for(int i=0; i<255; i++) {
//                try {
//                    currentAddress = InetAddress.getByName(String.format("%s%s", address, i));
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    currentAddress.isReachable(50);
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//            return list;
//        }
}
