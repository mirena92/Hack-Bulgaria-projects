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

        for (NetworkInterface netint : Collections.list(nets))
            if (!netint.isVirtual() && !netint.isLoopback() && netint.isUp()) {
                getIPAddress(netint);
            }
    }

    public static void getIPAddress(NetworkInterface netint) throws SocketException {
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            if (inetAddress instanceof Inet4Address && !inetAddress.equals(null)) {
                System.out.printf("InetAddress: %s\n", inetAddress);
            }
        }
    }
}
