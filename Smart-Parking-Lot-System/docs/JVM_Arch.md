The JVM consists of:
- Class Loader Subsystem: loads .class files
- Runtime Data Areas: Method Area, Heap, Java Stacks, PC Registers, Native Method Stacks
- Execution Engine: Interpreter + Just-In-Time (JIT) compiler
- Garbage Collector: manages heap memory

Key differences: Interpreter executes bytecode line-by-line; JIT compiles hot code paths into native machine code for performance.