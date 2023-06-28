BMV2_SWITCH_EXE = simple_switch_grpc

network:
	mkdir build
	mkdir logs
	p4c-bm2-ss --p4v 16 --p4runtime-files build/config1.p4.p4info.txt -o build/config1.json config1.p4
	p4c-bm2-ss --p4v 16 --p4runtime-files build/config2.p4.p4info.txt -o build/config2.json config2.p4
	(sleep 10s; python3 setup.py) & sudo python3 utils/run_exercise.py -t topology.json -b simple_switch_grpc

clean:
	rm -rf build
	rm -rf logs
	sudo mn -c

# p4c-bm2-ss --p4v 16 --p4runtime-files build/config1.p4.p4info.json -o build/config1.json config1.p4
# p4c-bm2-ss --p4v 16 --p4runtime-files build/config2.p4.p4info.json -o build/config2.json config2.p4
