package com.carseller.cars.tasks;

import com.carseller.cars.service.CatalogueService;
import com.carseller.cars.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class FordIngesterTask {

  @Value("${cars.ford.ingester.fileLocation}")
  private String fileLocation;

  private final CatalogueService catalogueService;

  @Scheduled(cron = "${cars.ford.ingester.runCron}")
  public void ingestFile() throws IOException {
    catalogueService.loadCatalogue(fileLocation,"Ford");
  }
}
