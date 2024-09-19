import random
import time
import sys

def generate_random_array(size):
    return [random.randint(0, 1000000) for _ in range(size)]

def run_load_test(n):
    print(f"Starting sort test with array size: {n}")
    large_array = generate_random_array(n)
    
    print("Sorting array...")
    start_time = time.time()
    
    large_array.sort()  # Sort the array in place
    
    end_time = time.time()
    print(f"Sorting completed in {end_time - start_time:.2f} seconds.")

def cleanup():
    print("Performing cleanup...")

def main():
    if len(sys.argv) < 2:
        print("Error: Please specify a mode ('run' or 'cleanup').")
        return

    mode = sys.argv[1]
    
    if mode == 'run':
        if '-n' in sys.argv:
            try:
                n_index = sys.argv.index('-n') + 1
                n = int(sys.argv[n_index])
                run_load_test(n)
            except (IndexError, ValueError):
                print("Error: Please supply a valid number after '-n'")
        else:
            print("Error: Please supply the '-n' argument.")
    elif mode == 'cleanup':
        cleanup()
    else:
        print(f"Error: Unknown mode '{mode}'")

if __name__ == "__main__":
    main()
