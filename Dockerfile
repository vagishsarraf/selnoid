version: '1'
services:
  selenoid:
    image: "aerokube/selenoid:latest"
    container_name: selenoid
    ports:
      - "4445:4444"
    networks:
      - selenoid
    volumes:
      - ".:/etc/selenoid"
      - "./target:/output"
      - "/var/run/docker.sock:/var/run/docker.sock"
      - "./target:/opt/selenoid/video"
    environment:
      - "OVERRIDE_VIDEO_OUTPUT_DIR=$PWD/target"
    command: ["-conf", "/etc/selenoid/browsers.json", "-video-output-dir", "/opt/selenoid/video", "-container-network", "selenoid"]
  selenoid-ui:
    image: "aerokube/selenoid-ui:latest"
    container_name: selenoid-ui
    links:
      - selenoid
    ports:
      - "8083:8080"
    networks:
      - selenoid
    command: ["--selenoid-uri", "http://selenoid:4444"]
  chrome_120.0:
    image: "selenoid/vnc:chrome_120.0"
    container_name: chrome_120.0
    links:
      - selenoid
      - selenoid-ui
    depends_on:
      - selenoid
      - selenoid-ui
    networks:
      - selenoid
    volumes:
      - "/dev/shm:/dev/shm"
networks:
  selenoid:
    external:
      name: selenoid