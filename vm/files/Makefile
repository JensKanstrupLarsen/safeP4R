BMV2_SWITCH_EXE = simple_switch_grpc

test: | clean build network

build:
	mkdir build
	mkdir logs
	p4c-bm2-ss --p4v 16 --p4runtime-files build/config1.p4.p4info.txt -o build/config1.json config1.p4
	p4c-bm2-ss --p4v 16 --p4runtime-files build/config2.p4.p4info.txt -o build/config2.json config2.p4
	p4c-bm2-ss --p4v 16 --p4runtime-files build/config1.p4.p4info.json -o build/config1.json config1.p4
	p4c-bm2-ss --p4v 16 --p4runtime-files build/config2.p4.p4info.json -o build/config2.json config2.p4

network:
	(sleep 7s; python3 setup.py; echo "Ready to receive requests!") & sudo python3 utils/run_exercise.py -t topology.json -b simple_switch_grpc

clean:
	sudo mn -c
	rm -rf build
	rm -rf logs
