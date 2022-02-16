package com.carseller.cars.tasks;

import com.carseller.cars.service.CatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class FordIngesterTask {

  @Value("${cars.ford.ingester.fileLocation}")
  private String fileLocation;

  private final CatalogueService catalogueService;

  @Scheduled(cron = "${cars.ford.ingester.runCron}")
  public void ingestFile()  {
    catalogueService.loadCatalogue(fileLocation,"Ford");
  }
}
