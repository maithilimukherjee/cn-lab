def binary_to_decimal(binary):
    
    parts = binary.split('.')
    decimal = [int(part, 2) for part in parts]
    
    return '.'.join(str(num) for num in decimal)

#get network class and default subnet mask

def get_network_class(parts):
    
    first = int(parts[0])
    
    if 1<=first<=126:
        return "A", "255.0.0.0"
    
    elif 128<=first<=191:
        return "B", "255.255.0.0"
    
    elif 192<=first<=223:
        return "C", "255.255.255.0"
    
    elif 224<=first<=239:
        return "D", "Multicast"
    
    elif 240<=first<=255:
        return "E", "Experimental"
    
    else:
        return "Invalid", "Invalid"
    
def get_network_address(ip_parts, ip_class):
    
    if ip_class == "A":
        
        return f"{ip_parts[0]}.0.0.0"
    
    elif ip_class == "B":
        
        return f"{ip_parts[0]}.{ip_parts[1]}.0.0"
    
    elif ip_class == "C":
        
        return f"{ip_parts[0]}.{ip_parts[1]}.{ip_parts[2]}.0"
    
    else:
        return "N/A"
    

choice = int(input("Enter 1 for binary input or 2 for decimal input: "))

if choice == 1:
    
    ip_address = binary_to_decimal(input("Enter the binary IP address: "))
    
elif choice == 2:
    
    ip_address = input("Enter the decimal IP address: ")
    
else:
    print("Invalid choice.")
    exit()
    
ip_parts = ip_address.split('.')

ip_class, default_subnet_mask = get_network_class(ip_parts)
network_address = get_network_address(ip_parts, ip_class)

print(f"IP Address: {ip_address}")
print(f"Network Class: {ip_class}")
print(f"Default Subnet Mask: {default_subnet_mask}")
print(f"Network Address: {network_address}")
