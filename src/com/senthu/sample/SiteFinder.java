package com.senthu.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
{
    "site1" : [10.10.10.0/24, 10.10.11.0/24],
    "site2" : [10.10.12.0/24, 10.10.13.0/24, 10.10.14.0/24]
}

String message with IP 10.10.12.5 - Site 2
String message with IP 10.10.10.7 - Site 1

/24 x.x.x.1 to x.x.x.254
/16 x.x.0.1 to x.x.254.254
*/

class IPv4Address {

	private Integer octet1;
	private Integer octet2;
	private Integer octet3;
	private Integer octet4;
	private boolean isValid = false;

	public IPv4Address(String ipAddress) {
		if ((ipAddress == null) || ipAddress.isBlank()) {
			return;
		}
		String[] splittedOctet = ipAddress.split("[.]");
		try {
			if (splittedOctet.length != 4) {
				throw new Exception("Invalid IP Address");
			}
			this.octet1 = Integer.valueOf(splittedOctet[0]);
			this.octet2 = Integer.valueOf(splittedOctet[1]);
			this.octet3 = Integer.valueOf(splittedOctet[2]);
			this.octet4 = Integer.valueOf(splittedOctet[3]);

			this.isValid = this.isValidOctet(this.octet1) && this.isValidOctet(this.octet2)
					&& this.isValidOctet(this.octet3) && this.isValidOctet(this.octet4);

			if (!this.isValid) {
				throw new Exception("Invalid IP Address (Invalid Octet)");
			}
		} catch (Exception e) {
			this.isValid = false;
		}
	}

	public Integer getOctet1() {
		return this.octet1;
	}

	public Integer getOctet2() {
		return this.octet2;
	}

	public Integer getOctet3() {
		return this.octet3;
	}

	public Integer getOctet4() {
		return this.octet4;
	}

	private boolean isValidOctet(Integer octet) {
		return (octet == null) || (octet < 0) || (octet > 254);
	}

	public String toFormattedString() {
		return String.format("%03d%03d%03d%03d", this.getOctet1(), this.getOctet2(), this.getOctet3(),
				this.getOctet4());
	}

	@Override
	public String toString() {
		return String.format("%d.%d.%d.%d", this.getOctet1(), this.getOctet2(), this.getOctet3(), this.getOctet4());
	}
}

public class SiteFinder {

	public static String generateRandomIPAddress() {
		return String.format("%d.%d.%d.%d", new Random().nextInt(1, 255), new Random().nextInt(1, 255),
				new Random().nextInt(1, 255), new Random().nextInt(1, 255));
	}

	public static String generateRandomSubnet() {
		return String.format("%d.%d.%d.%d/%d", new Random().nextInt(1, 255), new Random().nextInt(1, 255),
				new Random().nextInt(1, 255), new Random().nextInt(1, 255), new Random().nextInt(1, 4) * 8);
	}

	public static void main(String[] args) {
		HashMap<String, Set<String>> subnetSiteMap = new HashMap<>();

		Set<String> allSubnets = new HashSet<>();
		for (int i = 0; i < 200; i++) {
			String siteName = String.format("Site-%04d", (i + 1));
			Set<String> subnetPerSite = new HashSet<>();
			for (int j = 0; j < new Random().nextInt(10, 1000); j++) {
				String subnet = SiteFinder.generateRandomSubnet();
				if (!allSubnets.contains(subnet)) {
					subnetPerSite.add(subnet);
				}
				allSubnets.add(subnet);
			}
			subnetSiteMap.put(siteName, subnetPerSite);
		}

		HashMap<String, String> startIPAddressAndSiteMap = new HashMap<>();
		HashMap<String, List<SubnetAddress>> subnetAddressSiteMap = new HashMap<>();
		for (String siteName : subnetSiteMap.keySet()) {
			Set<String> subnetStringSet = subnetSiteMap.get(siteName);
			List<SubnetAddress> subnetAddressList = new ArrayList<>();
			for (String subnet : subnetStringSet) {
				subnetAddressList.add(new SubnetAddress(subnet));
			}
			subnetAddressSiteMap.put(siteName, subnetAddressList);
			System.out.println("Site Name : " + siteName);
			for (SubnetAddress subnetAddress : subnetAddressList) {
				System.out.println("\t" + subnetAddress.toString());
				startIPAddressAndSiteMap.put(subnetAddress.getStartIP().toFormattedString(), siteName);
			}
		}

		for (int i = 0; i < new Random().nextInt(50, 100); i++) {
			String generatedIPAddress = SiteFinder.generateRandomIPAddress();
			IPv4Address ipAddress = new IPv4Address(generatedIPAddress);
			String subnet8IP = String.format("%03d%03d%03d%03d", ipAddress.getOctet1(), 0, 0, 0);
			if (startIPAddressAndSiteMap.containsKey(subnet8IP)) {
				System.out.println(generatedIPAddress + " Belongs to " + startIPAddressAndSiteMap.get(subnet8IP));
				continue;
			}
			String subnet16IP = String.format("%03d%03d%03d%03d", ipAddress.getOctet1(), ipAddress.getOctet2(), 0, 0);
			if (startIPAddressAndSiteMap.containsKey(subnet16IP)) {
				System.out.println(generatedIPAddress + " Belongs to " + startIPAddressAndSiteMap.get(subnet16IP));
				continue;
			}
			String subnet24IP = String.format("%03d%03d%03d%03d", ipAddress.getOctet1(), ipAddress.getOctet2(),
					ipAddress.getOctet3(), 0);
			if (startIPAddressAndSiteMap.containsKey(subnet24IP)) {
				System.out.println(generatedIPAddress + " Belongs to " + startIPAddressAndSiteMap.get(subnet24IP));
				continue;
			}
			System.out.println(generatedIPAddress + " DOES NOT Belongs to ANY SITE");
		}

	}
}

class SubnetAddress {

	private IPv4Address subnetIP = null;
	private IPv4Address startIP = null;
	private IPv4Address endIP = null;
	private Integer subnet = null;

	public SubnetAddress(String subnetAddress) {
		if ((subnetAddress == null) || subnetAddress.isBlank()) {
			return;
		}
		String[] splitedString = subnetAddress.split("/");
		if (splitedString.length == 2) {
			this.subnet = Integer.valueOf(splitedString[1]);
			this.subnetIP = new IPv4Address(splitedString[0]);

			if (this.subnet == 8) {
				this.startIP = new IPv4Address(this.subnetIP.getOctet1() + ".0.0.0");
				this.endIP = new IPv4Address(this.subnetIP.getOctet1() + ".254.254.254");
			}
			if (this.subnet == 16) {
				this.startIP = new IPv4Address(this.subnetIP.getOctet1() + "." + this.subnetIP.getOctet2() + ".0.0");
				this.endIP = new IPv4Address(this.subnetIP.getOctet1() + "." + this.subnetIP.getOctet2() + ".254.254");
			}
			if (this.subnet == 24) {
				this.startIP = new IPv4Address(this.subnetIP.getOctet1() + "." + this.subnetIP.getOctet2() + "."
						+ this.subnetIP.getOctet3() + ".0");
				this.endIP = new IPv4Address(this.subnetIP.getOctet1() + "." + this.subnetIP.getOctet2() + "."
						+ this.subnetIP.getOctet3() + ".254");
			}
		}
	}

	public IPv4Address getEndIP() {
		return this.endIP;
	}

	public IPv4Address getStartIP() {
		return this.startIP;
	}

	public Integer getSubnet() {
		return this.subnet;
	}

	public IPv4Address getSubnetIP() {
		return this.subnetIP;
	}

	@Override
	public String toString() {
		return String.format("SubnetAddress [subnetIP=%s, subnet=%s, startIP=%s, endIP=%s]", this.subnetIP, this.subnet,
				this.startIP, this.endIP);
	}

}