def binary_to_decimal(binary_ip):
    parts = binary_ip.split('.')
    decimal_parts = [str(int(part, 2)) for part in parts]
    return '.'.join(decimal_parts)


def get_ip_class(first_octet):
    if 1 <= first_octet <= 126:
        return "A", "255.0.0.0"
    elif 128 <= first_octet <= 191:
        return "B", "255.255.0.0"
    elif 192 <= first_octet <= 223:
        return "C", "255.255.255.0"
    elif 224 <= first_octet <= 239:
        return "D", "Not Defined (Multicast)"
    elif 240 <= first_octet <= 255:
        return "E", "Not Defined (Experimental)"
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
        return "Not Applicable"


# Input
ip = input("Enter IP address (decimal or binary): ")

# Detect binary or decimal
if all(ch in '01.' for ch in ip):
    ip = binary_to_decimal(ip)

ip_parts = list(map(int, ip.split('.')))

# Determine class
ip_class, subnet = get_ip_class(ip_parts[0])

# Network address
network_address = get_network_address(ip_parts, ip_class)

# Output
print("\nIP Address:", ip)
print("Class:", ip_class)
print("Default Subnet Mask:", subnet)
print("Network Address:", network_address)
