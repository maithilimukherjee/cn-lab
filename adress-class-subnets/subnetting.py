import math

# Input IP address
ip_address = input("Enter the IP address: ")

parts = list(map(int, ip_address.split('.')))
first_octet = parts[0]

# Determine IP class
if 1 <= first_octet <= 126:
    ip_class = 'A'
    default_bits = 8

elif 128 <= first_octet <= 191:
    ip_class = 'B'
    default_bits = 16

elif 192 <= first_octet <= 223:
    ip_class = 'C'
    default_bits = 24

else:
    print("Invalid IP address.")
    exit()

# Input required number of subnets
subnets = int(input("Enter the number of subnets required: "))

# Calculate borrowed bits
subnet_bits = math.ceil(math.log2(subnets))

# New subnet mask length
new_mask_bits = default_bits + subnet_bits

# Generate subnet mask
mask = [0, 0, 0, 0]

for i in range(new_mask_bits):
    mask[i // 8] += 1 << (7 - (i % 8))

subnet_mask = '.'.join(map(str, mask))

# Calculate network address using bitwise AND
network = []

for i in range(4):
    network.append(parts[i] & mask[i])

network_address = '.'.join(map(str, network))

# Output
print("ip_address:", ip_address)
print("ip_class:", ip_class)
print("subnet_mask:", subnet_mask)
print("network_address:", network_address)