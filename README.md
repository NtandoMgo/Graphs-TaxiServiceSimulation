# Taxi Service Simulation

This repository contains a Java program, `SimulatorOne.java`, that simulates a taxi service offered by the supermarket chain QnQ. The program uses directed graphs and Dijkstra's algorithm to calculate the lowest cost trip for each incoming call.

## Introduction

The simulation involves taxis stationed at QnQ shops, clients requesting a taxi to the nearest QnQ shop, and a directed graph representing routes the taxis take. The program calculates the lowest cost path from a taxi to a client to the nearest shop using Dijkstra's algorithm.

## Input Format

The input file contains data on roads, shop locations, and incoming calls. The format includes the number of nodes, edges, shops, clients, and chronological call events. Each call event represents a client requesting a taxi from a specific node.

## Output Format

The output is ordered by call event and provides details of the lowest cost pick-up and drop-off for each client. It includes information about the taxi node, the shortest path from the taxi to the client, the shop node, and the shortest path from the client to the shop. In cases of multiple solutions or no path, appropriate messages are provided.

## Usage

To run the simulation, compile `SimulatorOne.java` and provide an input file containing the required data. The program will then calculate and output details of the lowest cost trip for each incoming call.

Example Usage:
```bash
java SimulatorOne input.txt
